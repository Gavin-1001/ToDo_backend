package com.todo.backend.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //removes the property from the response, can write only
    private String id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Transient
    private String accessToken;

    @Transient
    private String refreshToken;


    public User(String id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(){

    }


}
