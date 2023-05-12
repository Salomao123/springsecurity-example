package com.salomao.springsecurityexample.user.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull(message = "Field 'email' is mandatory")
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull(message = "Field 'login' is mandatory")
    @Column(nullable = false, unique = true)
    private String login;

    @NotNull(message = "Field 'password' is mandatory")
    @Column(nullable = false)
    private String password;

}
