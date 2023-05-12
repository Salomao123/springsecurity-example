package com.salomao.springsecurityexample.user.endpoint.controller;

import com.salomao.springsecurityexample.user.domain.dto.UserDTO;
import com.salomao.springsecurityexample.user.domain.entity.User;
import com.salomao.springsecurityexample.user.endpoint.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@Api(value = "Endpoints to manage users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "List users by id", response = User.class)
    public User getUsers(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    @ApiOperation(value = "List all users", response = User[].class)
    public Iterable<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/save")
    @ApiOperation(value = "Create new user", response = User.class)
    public User createUser(@RequestBody UserDTO userDTO) {
        return userService.create(userDTO);
    }
}
