package com.auth_application.auth.application.authenticate;

import com.auth_application.auth.domain.AuthServices;
import com.auth_application.auth.domain.UserAuthPassword;
import com.auth_application.shared.domain.UserAuthUserName;
import com.auth_application.shared.domain.bus.command.CommandHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserCreadentialsValidateCommandHandler implements CommandHandler<UserCreadentialsValidateCommand> {

    private final AuthServices authServices;

    @Override
    public void handle(UserCreadentialsValidateCommand command) {

        UserAuthUserName userName = new UserAuthUserName(command.getUserName());
        UserAuthPassword password = new UserAuthPassword(command.getPassword());

        authServices.ensureCredentialsAreValid(userName, password);

    }
}
