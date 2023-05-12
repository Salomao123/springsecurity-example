package com.salomao.springsecurityexample.user.repository;

import com.salomao.springsecurityexample.user.domain.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {
    @Mock
    private UserRepository userRepository;

    private User user1;
    private User user2;

    @BeforeEach
    public void setup() {
        this.user1 = User.builder().login("salomao").email("salomao.batista@gmail.com").password("1234").build();
        this.user2 = User.builder().login("enzo.gabriel").email("enzo.gabriel@gmail.com").password("1234").build();
    }

    @Test
    public void testFindAllUsers() {
        Iterable<User> userList = Arrays.asList(user1, user2);
        when(userRepository.findAll()).thenReturn(userList);
        Iterable<User> result = userRepository.findAll();
        assertEquals(userList, result);
    }

    @Test
    public void testFindUserById() {
        when(userRepository.findById(any())).thenReturn(Optional.of(user1));
        Optional<User> result = userRepository.findById(1L);
        assertEquals(Optional.of(user1), result);
    }

    @Test
    public void testSaveUser() {
        when(userRepository.save(user1)).thenReturn(user1);
        User savedUser = userRepository.save(user1);
        assertEquals(user1, savedUser);
    }

    @Test
    public void testDeleteUser() {
        userRepository.deleteById(any());
        verify(userRepository, times(1)).deleteById(any());
    }
}

