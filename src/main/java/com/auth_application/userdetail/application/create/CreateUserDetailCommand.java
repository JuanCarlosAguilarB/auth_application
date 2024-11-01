package com.auth_application.userdetail.application.create;


import com.auth_application.shared.domain.bus.command.Command;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CreateUserDetailCommand implements Command {

    private UUID id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String userName;

}
