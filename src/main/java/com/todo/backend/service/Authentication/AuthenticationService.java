package com.todo.backend.service.Authentication;

import com.todo.backend.entity.User;

public interface AuthenticationService {
    User signInAndReturnJwt(User user);
}
