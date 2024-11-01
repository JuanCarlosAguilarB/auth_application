package com.auth_application.auth.application.create;

import com.auth_application.auth.domain.*;
import com.auth_application.auth.domain.event.UserCreatedEvent;
import com.auth_application.shared.domain.UserAuthId;
import com.auth_application.shared.domain.UserAuthUserName;
import com.auth_application.shared.domain.bus.event.EventBus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UserCreator {

    private final UserAuthRepository repository;
    private final SecurityService securityService;
    private final EventBus eventBus;


    /**
     * Creates a new user with the provided user details and generates an authentication token.
     *
     * @throws DuplicateEmailException If the provided email or username is already registered.
     */
    public void createUser(UserAuthId id, UserAuthEmail email, UserAuthUserName userName, UserAuthPassword password) {

//        ensureEmailAndUserNameAreNotRegistered(email, userName);

        String rawPassword = password.value();
        UserAuthPassword passwordEncoded = new UserAuthPassword(securityService.encode(rawPassword));

        LocalDateTime now = LocalDateTime.now();
        UserAuth user = new UserAuth(
                id,
                email,
                userName,
                passwordEncoded,
                new UserAuthIsVerified(false),
                new UserAuthDateCreated(now),
                new UserAuthDateLastLogin(now)
                );

        repository.save(user);
        UserCreatedEvent userCreatedEvent = new UserCreatedEvent(
                id.value(),
                email.value(),
                userName.value(),
                now
        );
        eventBus.publish(List.of((userCreatedEvent)));
    }

    private void ensureEmailAndUserNameAreNotRegistered(UserAuthEmail email, UserAuthUserName userName) {

        boolean isEmailRegistered = repository.existsByEmail(email);
        boolean isUserNameRegistered = repository.existsByUsername(userName);

        if (isEmailRegistered && isUserNameRegistered) {
            throw new DuplicateEmailException("Both the email " + email.value() + " and username " + userName.value() + " are already registered. Please use different credentials.");
        } else if (isEmailRegistered) {
            throw new DuplicateEmailException("The email " + email + " is already registered. Please use a different email.");
        } else if (isUserNameRegistered) {
            throw new DuplicateEmailException("The username " + userName + " is already registered. Please use a different username.");
        }
    }

}