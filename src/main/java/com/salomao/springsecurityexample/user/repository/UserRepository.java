package com.salomao.springsecurityexample.user.repository;

import com.salomao.springsecurityexample.user.domain.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends PagingAndSortingRepository<User, UUID> {
    Optional<User> findByLogin(String username);
}
