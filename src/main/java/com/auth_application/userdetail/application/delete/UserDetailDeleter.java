package com.auth_application.userdetail.application.delete;

import com.auth_application.userdetail.domain.UserDetailId;
import com.auth_application.userdetail.domain.UserDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserDetailDeleter {

    private final UserDetailRepository userDetailRepository;

    public void delete(UserDetailId id) {
        userDetailRepository.delete(id);
    }

}
