package com.salomao.springsecurityexample.user.endpoint.service;

import com.salomao.springsecurityexample.exceptions.UserNotFoundException;
import com.salomao.springsecurityexample.user.domain.entity.User;
import com.salomao.springsecurityexample.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    public void setup() {
        userService = new UserService(userRepository);
    }

    @Test
    public void testGetUserById() {
        User user = User.builder().login("salomao").email("salomao.batista@gmail.com").password("1234").build();
        when(userRepository.findById(any())).thenReturn(Optional.of(user));
        User result = userService.getUserById(UUID.randomUUID());
        assertEquals(user, result);
    }

    @Test
    public void testGetUserByIdNotFound() {
        when(userRepository.findById(any())).thenThrow(UserNotFoundException.class);
        assertThrows(UserNotFoundException.class, () -> userService.getUserById(UUID.randomUUID()));
    }

}
