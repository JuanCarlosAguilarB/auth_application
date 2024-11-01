package com.auth_application.auth.domain;

import com.auth_application.shared.domain.UserAuthId;
import com.auth_application.shared.domain.UserAuthUserName;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserAuth {

    private final UserAuthId userId;
    private final UserAuthEmail email;
    private final UserAuthUserName userName;
    private final UserAuthPassword password;
    private final UserAuthIsVerified isVerified;
    private final UserAuthDateCreated created;
    private final UserAuthDateLastLogin lastLogin;

    public UserAuthId id() {
        return userId;
    }

    public UserAuthEmail email() {
        return email;
    }

    public UserAuthUserName userName() {
        return userName;
    }

    public UserAuthPassword password() {
        return password;
    }

    public UserAuthIsVerified isVerified() {
        return isVerified;
    }

    public UserAuthDateCreated created() {
        return created;
    }

    public UserAuthDateLastLogin lastLogin() {
        return lastLogin;
    }

}
