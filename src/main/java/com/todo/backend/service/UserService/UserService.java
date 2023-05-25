package com.todo.backend.service.UserService;

import com.todo.backend.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);

    User saveUser(User user);
}
