package com.auth_application.auth.application.find;

import com.auth_application.auth.domain.UserAuth;
import com.auth_application.auth.domain.UserAuthRepository;
import com.auth_application.shared.domain.UserAuthId;
import com.auth_application.shared.domain.UserAuthUserName;
import com.auth_application.userdetail.domain.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserFinder {

    private final UserAuthRepository repository;

    /**
     * Retrieves a user by the specified username.
     *
     * @param username The username of the user to retrieve.
     * @return The UserDetail object corresponding to the specified username.
     * @throws UserNotFoundException If no user is found with the specified username.
     */
    public UserAuth findUserByUsername(UserAuthUserName username) {
//        return repository.findByUsername(username)
//                .orElseThrow(() -> new UserNotFoundException("user not found with username: " + username));
        return null;
    }

    public UserAuth findById(UserAuthId userId) {
//        return repository.findById(userId)
//                .orElseThrow(() -> new UserNotFoundException("user not found with id: " + userId));
        return null;
    }

}
