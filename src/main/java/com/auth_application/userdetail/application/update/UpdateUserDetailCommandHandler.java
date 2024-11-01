package com.auth_application.userdetail.application.update;

import com.auth_application.shared.domain.bus.command.CommandHandler;
import com.auth_application.userdetail.domain.UserDetailId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateUserDetailCommandHandler implements CommandHandler<UpdateUserDetailCommand> {

    private final UserDetailUpdater service;

    @Override
    public void handle(UpdateUserDetailCommand command) {
        service.update(new UserDetailId(command.getId()), command.getData());
    }
}
