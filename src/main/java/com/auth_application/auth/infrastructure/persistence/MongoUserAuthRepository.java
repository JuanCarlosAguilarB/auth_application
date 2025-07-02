package com.auth_application.auth.infrastructure.persistence;

import com.auth_application.auth.domain.UserAuth;
import com.auth_application.auth.domain.UserAuthEmail;
import com.auth_application.auth.domain.UserAuthRepository;
import com.auth_application.shared.domain.UserAuthUserName;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.auth_application.auth.infrastructure.persistence.UserAuthMapper.toEntity;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
@AllArgsConstructor
public class MongoUserAuthRepository implements UserAuthRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public boolean existsByUsername(UserAuthUserName username) {

        Criteria criteria = where("userName").is(username.value());
        return mongoTemplate.exists(query(criteria), UserDocumentEntity.class);
    }

    @Override
    public void save(UserAuth user) {
        mongoTemplate.save(toEntity(user));
    }

    @Override
    public Optional<UserAuth> findByUsername(UserAuthUserName username)  {

        Criteria criteria = where("userName").is(username.value());
        UserDocumentEntity userDocumentEntity = mongoTemplate.findOne(query(criteria), UserDocumentEntity.class);

        return Optional.ofNullable(userDocumentEntity)
                .map(UserAuthMapper::toDomain);

    }


    @Override
    public boolean existsByEmail(UserAuthEmail email) {
        return mongoTemplate.exists(
                query(
                        where("email").is(email.value())
                ),
                UserDocumentEntity.class
        );
    }
//
//    @Override
//    public Stream<UserAuth> findByEmail(UserAuthEmail email) {
//        return repository.findByEmail(email.value()).stream()
//                .map(UserAuthMapper::toDomain);
//    }
//
//    @Override
//    public Optional<UserAuth> findById(UserAuthId userId) {
//        return repository.findById(userId.value())
//                .map(UserAuthMapper::toDomain);
//    }

}
