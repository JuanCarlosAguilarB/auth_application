package com.auth_application.auth.application.update;

import com.auth_application.shared.domain.bus.command.Command;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class UserLoginCommand implements Command {

    public String userName;
    public LocalDateTime loginDate;

}
