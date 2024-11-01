package com.auth_application.auth.domain;

import com.auth_application.shared.domain.UserAuthUserName;

public interface AuthServices {

    public TokenUserResponse createToken(UserAuthUserName userName);

    public UserAuth decode(TokenUserResponse token);

    public void ensureCredentialsAreValid(UserAuthUserName userName, UserAuthPassword password) throws CreadentialsNotValidException;

    public Boolean isValidToken(String token, String username);
}
