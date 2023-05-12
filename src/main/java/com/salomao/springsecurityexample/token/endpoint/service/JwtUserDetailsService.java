package com.salomao.springsecurityexample.token.endpoint.service;

import java.util.ArrayList;
import java.util.Objects;

import com.salomao.springsecurityexample.exceptions.UserNotFoundException;
import com.salomao.springsecurityexample.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.salomao.springsecurityexample.user.domain.entity.User user = userRepository.findByLogin(username).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));

        if (Objects.equals(user.getLogin(), username)) {
            return new User(user.getLogin(), user.getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}