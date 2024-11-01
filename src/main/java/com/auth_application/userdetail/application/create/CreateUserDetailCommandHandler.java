package com.auth_application.userdetail.application.create;


import com.auth_application.shared.domain.UserAuthUserName;
import com.auth_application.shared.domain.bus.command.CommandHandler;
import com.auth_application.userdetail.domain.UserDetailFirstName;
import com.auth_application.userdetail.domain.UserDetailId;
import com.auth_application.userdetail.domain.UserDetailLastName;
import com.auth_application.userdetail.domain.UserDetailPhoneNumber;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CreateUserDetailCommandHandler implements CommandHandler<CreateUserDetailCommand> {

    private final UserDetailCreator service;

    @Override
    public void handle(CreateUserDetailCommand command) {
        System.out.println("CreateUserDetailCommand");

        service.createUser(
                new UserDetailId(command.getId()),
                new UserDetailFirstName(command.getFirstName()),
                new UserDetailLastName(command.getLastName()),
                new UserDetailPhoneNumber(command.getPhoneNumber()),
                new UserAuthUserName(command.getUserName())
        );

    }


}
