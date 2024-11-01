package com.auth_application.userdetail.domain;

import com.auth_application.shared.domain.PageResult;
import com.auth_application.shared.domain.bus.query.Response;
import lombok.ToString;

import java.util.List;

@ToString
public class AllUsersDetailResponse extends PageResult<UserDetail> implements Response {

    public AllUsersDetailResponse(List<UserDetail> content, int pageNumber, int pageSize, long totalElements) {
        super(content, pageNumber, pageSize, totalElements);
    }

}
