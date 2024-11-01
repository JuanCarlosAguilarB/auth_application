package com.auth_application.auth.domain;


import com.auth_application.shared.domain.UserAuthUserName;

import java.util.Optional;

public interface UserAuthRepository {

    boolean existsByUsername(UserAuthUserName username);
    void save(UserAuth user);
    Optional<UserAuth> findByUsername(UserAuthUserName username);
    boolean existsByEmail(UserAuthEmail email);
//    Optional<UserAuth> findById(UserAuthId userId);
}
