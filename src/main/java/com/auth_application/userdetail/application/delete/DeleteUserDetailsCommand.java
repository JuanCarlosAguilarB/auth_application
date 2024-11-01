package com.auth_application.userdetail.application.delete;

import com.auth_application.shared.domain.bus.command.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class DeleteUserDetailsCommand implements Command {
    UUID id;
}
