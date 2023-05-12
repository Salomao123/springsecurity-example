package com.salomao.springsecurityexample.user.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class UserDTO {

    @JsonProperty
    private String login;

    @JsonProperty
    private String email;

    @JsonProperty
    private String password;


}
