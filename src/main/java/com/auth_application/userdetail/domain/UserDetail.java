package com.auth_application.userdetail.domain;

import com.auth_application.shared.domain.UserAuthUserName;
import lombok.AllArgsConstructor;
import lombok.ToString;


@ToString
@AllArgsConstructor
public class UserDetail {

    private UserDetailId id;
    private UserDetailFirstName firstName;
    private UserDetailLastName lastName;
    private UserDetailPhoneNumber phoneNumber;
    private UserAuthUserName userName;

    public UserDetailId id() {
        return id;
    }

    public UserDetailFirstName firstName() {
        return firstName;
    }

    public UserDetailLastName lastName() {
        return lastName;
    }

    public UserDetailPhoneNumber phoneNumber() {
        return phoneNumber;
    }

    public UserAuthUserName userName() {
        return userName;
    }
}
