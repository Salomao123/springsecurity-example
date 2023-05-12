package com.salomao.springsecurityexample.user.repository;

import com.salomao.springsecurityexample.user.domain.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Optional<User> findByLogin(String username);
}
