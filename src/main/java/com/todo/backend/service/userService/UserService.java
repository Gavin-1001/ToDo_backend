package com.todo.backend.service.userService;

import com.todo.backend.entity.User;
import com.todo.backend.requests.UserDto;

import java.util.Optional;

public interface UserService {


    Optional<User> findByUsername(String username);

    User saveUser(User user);
}
