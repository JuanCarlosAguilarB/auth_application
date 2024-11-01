package com.auth_application.auth.application.update;

import com.auth_application.auth.domain.UserAuthDateLastLogin;
import com.auth_application.shared.domain.UserAuthUserName;
import com.auth_application.shared.domain.bus.command.CommandHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserLoginCommandHandler implements CommandHandler<UserLoginCommand> {

    private final LastLoginDateUpdater lastLoginDateUpdater;

    @Override
    public void handle(UserLoginCommand command) {

        UserAuthUserName userName = new UserAuthUserName(command.getUserName());
        UserAuthDateLastLogin lastLoginDate = new UserAuthDateLastLogin(command.getLoginDate());

        lastLoginDateUpdater.update(userName, lastLoginDate);

    }
}
