package com.auth_application.shared.infrastructure.controllers;

import com.auth_application.auth.domain.AuthServices;
import com.auth_application.auth.domain.TokenUserResponse;
import com.auth_application.auth.domain.UserAuth;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class GetUserIdFromToken {

    private final AuthServices authServices;
    private final GetTokenFromRequest getTokenFromRequest;

    public UUID getUserId() {

        String token = getTokenFromRequest.getToken();

        if (token == null) {
            return null;
        }

        UserAuth user = authServices.decode(
                TokenUserResponse.builder().token(token).build()
        );

        return user.id().value();
    }

}
