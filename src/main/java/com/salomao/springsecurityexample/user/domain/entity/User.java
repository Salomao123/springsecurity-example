package com.salomao.springsecurityexample.user.domain.entity;

import javax.persistence.*;
import java.util.UUID;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @EqualsAndHashCode.Include
    private UUID id;

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
