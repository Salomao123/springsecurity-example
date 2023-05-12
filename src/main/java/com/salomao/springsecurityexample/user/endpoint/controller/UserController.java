package com.salomao.springsecurityexample.user.endpoint.controller;

import com.salomao.springsecurityexample.user.domain.dto.UserDTO;
import com.salomao.springsecurityexample.user.domain.entity.User;
import com.salomao.springsecurityexample.user.endpoint.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUsers(@Param("id") UUID IDUser) {
        return userService.getUserById(IDUser);
    }

    @GetMapping
    public Iterable<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/save")
    public User createUser(@RequestBody UserDTO userDTO) {
        return userService.create(userDTO);
    }
}
