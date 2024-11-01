package com.auth_application.auth.application.update;

import com.auth_application.auth.application.find.UserFinder;
import com.auth_application.auth.domain.UserAuth;
import com.auth_application.auth.domain.UserAuthDateLastLogin;
import com.auth_application.auth.domain.UserAuthRepository;
import com.auth_application.shared.domain.UserAuthUserName;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LastLoginDateUpdater {

    private final UserAuthRepository repository;
    private final UserFinder userFinder;

    public void update(UserAuthUserName userName, UserAuthDateLastLogin lastLoginDate) {

        // find and verify user exists
        UserAuth user = userFinder.findUserByUsername(userName);

        UserAuth userToUpdate = new UserAuth(
                user.id(), user.email(), user.userName(), user.password(), user.isVerified(), user.created(), new UserAuthDateLastLogin(lastLoginDate.value()));

        repository.save(userToUpdate);

    }
}
