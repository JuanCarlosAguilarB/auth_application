package com.auth_application.auth.domain;

import java.time.LocalDateTime;

public class UserAuthDateCreated {

    private LocalDateTime value;

    public UserAuthDateCreated(LocalDateTime value) {
        this.value = value;
    }

    public LocalDateTime value() {
        return value;
    }

}
