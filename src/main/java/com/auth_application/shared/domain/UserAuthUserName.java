package com.auth_application.shared.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public final class UserAuthUserName {

    private final String value;

    public UserAuthUserName(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
