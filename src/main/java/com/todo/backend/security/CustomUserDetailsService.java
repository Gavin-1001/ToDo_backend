package com.todo.backend.security;

import com.todo.backend.entity.User;
import com.todo.backend.service.userService.UserService;
import com.todo.backend.utils.SecurityUtils;
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

        User user = userService.findByUsername(username).orElseThrow( () -> new UsernameNotFoundException(username));

        Set<GrantedAuthority>  authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));

        //UseDetails
        return UserPrincipal.builder()
                .user(user)
                .id(Long.valueOf(user.getId()))
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
