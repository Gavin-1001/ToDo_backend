package com.todo.backend.requests;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class UserDto {

    @NotBlank(message = "Username cannot be blank")
    String username;

    @NotBlank(message="Password cannot be blank")
    String password;

}
