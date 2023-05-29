package com.todo.backend.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@Table(name="users")
public class User {


    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //removes the property from the response, can write only
    private String id;

    @Column(name="username",unique = true, nullable = false, length = 100)
    private String username;

    @Column(name="password", unique = true, nullable = false, length = 100 )
    private String password;

    @Transient
    private String accessToken;

    @Transient
    private String refreshToken;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        setRole(Role.USER);
    }
}
