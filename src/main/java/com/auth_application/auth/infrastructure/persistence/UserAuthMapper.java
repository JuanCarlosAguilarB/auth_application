package com.auth_application.auth.infrastructure.persistence;

import com.auth_application.auth.domain.*;
import com.auth_application.shared.domain.UserAuthId;
import com.auth_application.shared.domain.UserAuthUserName;

public class UserAuthMapper {

    public static UserAuth toDomain(UserDocumentEntity userDocumentEntity) throws UserEmailException {

        return new UserAuth(
                new UserAuthId(userDocumentEntity.getUserId()),
                new UserAuthEmail(userDocumentEntity.getEmail()),
                new UserAuthUserName(userDocumentEntity.getUserName()),
                new UserAuthPassword(userDocumentEntity.getPassword()),
                new UserAuthIsVerified(userDocumentEntity.getIsVerified()),
                new UserAuthDateCreated(userDocumentEntity.getCreated()),
                new UserAuthDateLastLogin(userDocumentEntity.getLastLogin())
        );
    }

    public static UserDocumentEntity toEntity(UserAuth user) {

        return UserDocumentEntity.builder()
                .userId(user.id().value().toString())
//                .userId(user.id().value())
                .userName(user.userName().value())
                .email(user.email().value())
                .password(user.password().value())
                .isVerified(user.isVerified().value())
                .lastLogin(user.lastLogin().value())
                .created(user.created().value())
                .build();
    }
}
