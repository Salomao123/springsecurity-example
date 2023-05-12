package com.salomao.springsecurityexample.user.endpoint.service;

import com.salomao.springsecurityexample.exceptions.UserNotFoundException;
import com.salomao.springsecurityexample.user.domain.entity.User;
import com.salomao.springsecurityexample.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(UUID IDUser) {
        Optional<User> optionalUser = userRepository.findById(IDUser);
        return optionalUser.orElseThrow(() -> new UserNotFoundException("Usuário não encontrado " + IDUser));
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}
