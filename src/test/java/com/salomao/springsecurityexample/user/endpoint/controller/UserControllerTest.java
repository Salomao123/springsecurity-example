package com.salomao.springsecurityexample.user.endpoint.controller;

import com.salomao.springsecurityexample.user.domain.entity.User;
import com.salomao.springsecurityexample.user.endpoint.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @Mock
    private UserService userService;

    private UserController userController;

    @Test
    public void testGetUsersPageable() throws Exception {
        User user1 = User.builder().login("salomao").email("salomao.batista@gmail.com").password("1234").build();
        User user2 = User.builder().login("enzo.gabriel").email("enzo.gabriel@gmail.com").password("1234").build();
        List<User> expectedUsers = Arrays.asList(user1, user2);
        Page<User> expectedPage = new PageImpl<>(expectedUsers);

        when(userService.getUsers()).thenReturn(expectedPage);
        userController = new UserController(userService);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content.length()").value(expectedUsers.size()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].login").value(user1.getLogin()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].email").value(user1.getEmail()));
    }
}


