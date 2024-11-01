package com.auth_application.userdetail.infrastructure.controllers;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RequestUserDetailUserDetailBody {
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;

}
