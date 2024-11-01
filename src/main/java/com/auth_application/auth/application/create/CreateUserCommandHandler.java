package com.auth_application.auth.application.create;

import com.auth_application.auth.domain.UserAuthEmail;
import com.auth_application.auth.domain.UserAuthPassword;
import com.auth_application.shared.domain.UserAuthId;
import com.auth_application.shared.domain.UserAuthUserName;
import com.auth_application.shared.domain.bus.command.CommandHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand> {

    private final UserCreator service;

    @Override
    public void handle(CreateUserCommand command) {
        System.out.println("CreateUserCommandHandler");

        service.createUser(
                new UserAuthId(command.getUserId()),
                new UserAuthEmail(command.getEmail()),
                new UserAuthUserName(command.getUserName()),
                new UserAuthPassword(command.getPassword())
        );

    }
}
