package com.base.user.repository;

import com.base.common.JPAQueryDslBaseRepository;
import com.base.user.entity.UserEntity;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * UserRepository.
 *
 * @author alex on 3/8/2024.
 * @version 1.0
 */
@Lazy
@Repository
public class UserRepository extends JPAQueryDslBaseRepository<UserEntity> implements
    IUserRepository {
    /**
     * Constructor.
     */
    public UserRepository() {
        super(UserEntity.class);
    }
}
