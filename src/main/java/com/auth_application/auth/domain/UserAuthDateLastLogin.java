package com.auth_application.auth.domain;

import java.time.LocalDateTime;

public class UserAuthDateLastLogin {

    private LocalDateTime value;

    public UserAuthDateLastLogin(LocalDateTime value) {
        this.value = value;
    }

    public LocalDateTime value() {
        return value;
    }
}
