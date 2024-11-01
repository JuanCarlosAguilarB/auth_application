package com.auth_application.auth.application.authenticate;

import com.auth_application.shared.domain.bus.command.Command;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCreadentialsValidateCommand implements Command {

    private String userName;
    private String password;

}
