package com.auth_application.auth.domain;

import com.auth_application.shared.domain.bus.query.Response;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenUserResponse implements Response {

    private String token;
    private String refreshToken;

}
