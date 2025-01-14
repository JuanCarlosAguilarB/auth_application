package com.auth_application.auth.infrastructure.security;

import com.auth_application.auth.application.find.UserFinder;
import com.auth_application.auth.domain.UserAuth;
import com.auth_application.shared.domain.UserAuthUserName;
import com.auth_application.userdetail.domain.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;

@Configuration
@AllArgsConstructor
public class AuthBeen {

    private final PasswordEncoder passwordEncoder;
    private final UserFinder userFinder;

    /**
     * Configures an AuthenticationManager bean for managing authentication.
     *
     * @param config The AuthenticationConfiguration for building the authentication manager.
     * @return An AuthenticationManager instance for managing authentication.
     * @throws Exception If an error occurs during authentication manager configuration.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


    /**
     * Configures an AuthenticationProvider bean for authenticating users.
     *
     * @return An AuthenticationProvider instance for user authentication.
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }

    @ExceptionHandler({UserNotFoundException.class})
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UserNotFoundException {

                UserAuth user = userFinder.findUserByUsername(new UserAuthUserName(username));

                if (user == null) {
                    throw new UserNotFoundException("UserDetail not found with username: " + username);
                }

                return new org.springframework.security.core.userdetails.User(
                        user.userName().value(), user.password().value(),
                        true, true, true, true, Collections.emptyList());
            }
        };
    }


}
