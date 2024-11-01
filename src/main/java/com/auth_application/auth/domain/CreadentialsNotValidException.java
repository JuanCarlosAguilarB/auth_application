package com.auth_application.auth.domain;

public class CreadentialsNotValidException extends RuntimeException {

    public CreadentialsNotValidException(String message) {
        super(message);
    }
}
