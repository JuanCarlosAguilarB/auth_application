package com.auth_application.userdetail.application.find;

import com.auth_application.shared.domain.bus.query.Query;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class FindUserDetailByIdQuery implements Query {
    UUID id;
}
