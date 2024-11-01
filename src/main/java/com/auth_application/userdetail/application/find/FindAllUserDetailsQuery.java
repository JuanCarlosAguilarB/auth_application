package com.auth_application.userdetail.application.find;

import com.auth_application.shared.domain.bus.query.Query;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class FindAllUserDetailsQuery implements Query {
    int pageNumber;
    int pageSize;
}
