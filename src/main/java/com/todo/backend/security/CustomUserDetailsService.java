package com.todo.backend.security;

import com.todo.backend.entity.User;
import com.todo.backend.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("No known user with username " + username));


        return UserPrincipal.builder()
                .user(user)
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();

    }
}
