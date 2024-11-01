package com.auth_application.userdetail.infrastructure.mapper;

import com.auth_application.shared.domain.UserAuthUserName;
import com.auth_application.userdetail.domain.*;
import com.auth_application.userdetail.infrastructure.persistence.UserDetailEntity;
import org.springframework.stereotype.Service;

@Service
public class UserDetailMapper {

    public static UserDetail toDomain(UserDetailEntity entity) {
        return new UserDetail(
                new UserDetailId(entity.getId()),
                new UserDetailFirstName(entity.getFirstName()),
                new UserDetailLastName(entity.getLastName()),
                new UserDetailPhoneNumber(entity.getPhoneNumber()),
                new UserAuthUserName(entity.getUsername())
        );
    }


    public static UserDetailEntity toEntity(UserDetail user) {
        return UserDetailEntity.builder()
                .id(user.id().value())
                .username(user.userName().value())
                .firstName(user.firstName().value())
                .lastName(user.lastName().value())
                .phoneNumber(user.phoneNumber().value())
                .build();
    }

}
