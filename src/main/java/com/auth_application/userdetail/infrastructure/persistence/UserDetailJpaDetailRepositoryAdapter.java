package com.auth_application.userdetail.infrastructure.persistence;

import com.auth_application.shared.domain.PageResult;
import com.auth_application.shared.domain.PaginationRequest;
import com.auth_application.userdetail.domain.AllUsersDetailResponse;
import com.auth_application.userdetail.domain.UserDetail;
import com.auth_application.userdetail.domain.UserDetailId;
import com.auth_application.userdetail.domain.UserDetailRepository;
import com.auth_application.userdetail.infrastructure.mapper.UserDetailMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDetailJpaDetailRepositoryAdapter implements UserDetailRepository {

    private final UserDetailJpaRepository userDetailJpaRepository;

    public UserDetailJpaDetailRepositoryAdapter(UserDetailJpaRepository userDetailJpaRepository) {
        this.userDetailJpaRepository = userDetailJpaRepository;
    }


    @Override
    public boolean existsByUsername(String userName) {
        return userDetailJpaRepository.existsByUsername(userName);
    }

    @Override
    public Optional<UserDetail> findByUsername(String username) {
        return userDetailJpaRepository.findByUsername(username)
                .map(UserDetailMapper::toDomain);
    }

    @Override
    public void save(UserDetail user) {
        UserDetailEntity userDetailEntity = UserDetailMapper.toEntity(user);
        userDetailJpaRepository.save(userDetailEntity);
    }

    @Override
    public Optional<UserDetail> findById(UserDetailId id) {
        Optional<UserDetailEntity> userSearched = userDetailJpaRepository.findById(id.value());
        return userSearched.map(UserDetailMapper::toDomain);
    }

    @Override
    public AllUsersDetailResponse findAll(PaginationRequest pageable) {

        Pageable pageableResult = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()); // page 0, size 20
        Page<UserDetailEntity> page = userDetailJpaRepository.findAll(pageableResult);

        PageResult<UserDetail> pageResult = new PageResult<UserDetail>(
                page.getContent().stream().map(UserDetailMapper::toDomain).toList(),
                page.getNumber(), page.getSize(), page.getTotalElements());

        return (AllUsersDetailResponse) pageResult;
    }

    @Override
    public void delete(UserDetailId id) {
        userDetailJpaRepository.deleteById(id.value());
    }

}
