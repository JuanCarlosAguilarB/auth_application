package com.auth_application.auth.application.authenticate;

import com.auth_application.auth.domain.AuthServices;
import com.auth_application.auth.domain.TokenUserResponse;
import com.auth_application.shared.domain.UserAuthUserName;
import com.auth_application.shared.domain.bus.query.QueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ObtainTokenUserQueryHandler implements QueryHandler<ObtainTokenUserQuery, TokenUserResponse> {

    private final AuthServices authServices;

    @Override
    public TokenUserResponse handle(ObtainTokenUserQuery query) {
        UserAuthUserName userName = new UserAuthUserName(query.userName);
        return authServices.createToken(userName);
    }
}
