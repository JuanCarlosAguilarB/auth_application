package com.auth_application.shared.infrastructure.controllers;//package com.bordify.shared.infrastructure.controllers;
//
//import com.bordify.auth.domain.AuthServices;
//import com.bordify.auth.domain.TokenUserResponse;
//import com.bordify.auth.domain.UserAuth;
//import com.bordify.shared.domain.UserAuthId;
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@AllArgsConstructor
//public class BeanUserId {
//
//    private final AuthServices authServices;
//    private final GetTokenFromRequest getTokenFromRequestService;
//
//    @Bean
//    public UserAuthId getUserId() {
//
//        String token = getTokenFromRequestService.getToken();
//
//        if (token == null) {
//            return null;
//        }
//
//        UserAuth user = authServices.decode(
//                TokenUserResponse.builder().token(token).build()
//        );
//
//        return user.id();
//    }
//
//
//}
//
//
