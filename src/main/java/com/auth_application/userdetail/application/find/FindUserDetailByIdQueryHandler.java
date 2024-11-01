package com.auth_application.userdetail.application.find;

import com.auth_application.shared.domain.bus.query.QueryHandler;
import com.auth_application.userdetail.domain.UserDetailId;
import com.auth_application.userdetail.domain.UserDetailResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindUserDetailByIdQueryHandler implements QueryHandler<FindUserDetailByIdQuery, UserDetailResponse> {

    private final UserDetailFinder service;

    @Override
    public UserDetailResponse handle(FindUserDetailByIdQuery query) {

        return service.findUserById(
                new UserDetailId(query.getId())
        );

    }
}
