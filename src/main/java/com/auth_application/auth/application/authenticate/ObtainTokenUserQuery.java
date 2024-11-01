package com.auth_application.auth.application.authenticate;

import com.auth_application.shared.domain.bus.query.Query;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ObtainTokenUserQuery implements Query {
    public String userName;
}
