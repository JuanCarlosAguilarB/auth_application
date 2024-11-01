package com.auth_application.userdetail.application.delete;

import com.auth_application.shared.domain.bus.command.CommandHandler;
import com.auth_application.userdetail.domain.UserDetailId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteUserDetailsCommandHandler implements CommandHandler<DeleteUserDetailsCommand> {

    private UserDetailDeleter service;

    @Override
    public void handle(DeleteUserDetailsCommand command) {
        service.delete(new UserDetailId(command.getId()));
    }
}
