package com.salomao.springsecurityexample.user.endpoint.service;

import com.salomao.springsecurityexample.exceptions.UserNotFoundException;
import com.salomao.springsecurityexample.user.domain.dto.UserDTO;
import com.salomao.springsecurityexample.user.domain.entity.User;
import com.salomao.springsecurityexample.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserService {

    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    public User create(UserDTO userDTO) {
        log.info("UserService - create - start");
        User user = User.builder().login(userDTO.getLogin()).email(userDTO.getEmail()).password(passwordEncoder.encode(userDTO.getPassword())).build();
        log.info("UserService - create - end [{}]", user.toString());
        return userRepository.save(user);
    }
}
