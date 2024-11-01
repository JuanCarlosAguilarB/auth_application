package com.auth_application.userdetail.application.find;

import com.auth_application.shared.domain.PaginationRequest;
import com.auth_application.shared.domain.bus.query.QueryHandler;
import com.auth_application.userdetail.domain.AllUsersDetailResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindAllUserDetailsQueryHandler implements QueryHandler<FindAllUserDetailsQuery, AllUsersDetailResponse> {

    private final UserDetailFinder service;

    @Override
    public AllUsersDetailResponse handle(FindAllUserDetailsQuery query) {

        PaginationRequest pagination = new PaginationRequest(query.getPageNumber(), query.pageSize);
        return service.getall(
                pagination
        );

    }
}
