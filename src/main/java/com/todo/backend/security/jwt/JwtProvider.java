package com.todo.backend.security.jwt;

import com.todo.backend.security.UserPrincipal;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface JwtProvider {
    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);

    String generateToken(UserPrincipal userPrincipal);

}
