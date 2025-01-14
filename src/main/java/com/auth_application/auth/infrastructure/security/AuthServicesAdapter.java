package com.auth_application.auth.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth_application.auth.application.find.UserFinder;
import com.auth_application.auth.domain.*;
import com.auth_application.shared.domain.UserAuthUserName;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class AuthServicesAdapter implements AuthServices {


    //    @Value("${jwt.secret}")
    private final String secret = "secret";
    private final LocalDate now = LocalDate.now();
    private final Algorithm algorithm = Algorithm.HMAC256(this.secret);
    private final UserFinder userFinder;
    private final SecurityService securityService;

    @Override
    public TokenUserResponse createToken(UserAuthUserName userName) {


        //    @Value("${jwt.refreshTokenExpirationInDays:11}")
        int refreshTokenExpirationInDays = 1100;

        //    @Value("${jwt.accessTokenExpirationInDays:10}")
        int accessTokenExpirationInDays = 1000;

        String username = userName.value();

        String accessToken = generateToken(accessTokenExpirationInDays, username);
        String refreshToken = generateToken(refreshTokenExpirationInDays, username);

        return TokenUserResponse.builder()
                .token(accessToken)
                .refreshToken(refreshToken)
                .build();

    }

    @Override
    public void ensureCredentialsAreValid(UserAuthUserName userName, UserAuthPassword password) {

        UserAuth userReadModel = userFinder.findUserByUsername(userName);

        if (!securityService.matches(password.value(), userReadModel.password().value())) {
            // TODO: throw Event of invalid credentials
            throw new CreadentialsNotValidException("Invalid credentials");
        }

        /* this method replaces the following code,

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        auth.getUserName(),
                        auth.getPassword()
                )
        );
        */

    }

    //    /**
//     * Validates whether the provided JWT token is valid for the given user details.
//     *
//     * @param token The JWT token to validate.
//     * @param username The usename  against which to validate the token.
//     * @return True if the token is valid for the given user details, false otherwise.
//     */
    @Override
    public Boolean isValidToken(String token, String username) {
        try {
            DecodedJWT decodedJWT = JWT.decode(token);

            LocalDate now = LocalDate.now();

            return !decodedJWT.getExpiresAt().before(java.sql.Date.valueOf(now)) ||
                    decodedJWT.getSubject().equals(username);

        } catch (JWTDecodeException exception) {
            return false;
        }
    }


    /**
     * Generates a JWT access token with the specified expiration and username.
     *
     * @param expirationInDays The expiration duration of the token in days.
     * @param subject          The username associated with the token.
     * @return The generated JWT access token.
     */
    private String generateToken(int expirationInDays, String subject) {

        LocalDate expiryDate = now.plusDays(expirationInDays);
        return JWT.create()
                .withSubject(subject)
                .withIssuedAt(java.sql.Timestamp.valueOf(now.atStartOfDay()))
                .withExpiresAt(java.sql.Timestamp.valueOf(expiryDate.atStartOfDay()))
                .sign(algorithm);
    }

    @Override
    public UserAuth decode(TokenUserResponse token) {
        DecodedJWT decodedJWT = JWT.decode(token.getToken());
        return userFinder.findUserByUsername(new UserAuthUserName(decodedJWT.getSubject()));
    }
}
