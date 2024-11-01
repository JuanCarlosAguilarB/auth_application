package com.auth_application.shared.domain;

import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode
public class UserAuthId {

    private final UUID userId;

    public UserAuthId(UUID userId) {
        this.userId = userId;
    }

    public UserAuthId(String userId) {
        this.userId = UUID.fromString(userId);
    }

    public UUID value() {
        return userId;
    }
}