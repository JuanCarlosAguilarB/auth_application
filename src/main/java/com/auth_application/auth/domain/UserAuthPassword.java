package com.auth_application.auth.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public final class UserAuthPassword {


    private final String value;

    public UserAuthPassword(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
