package com.todo.backend.controller;

import com.todo.backend.entity.User;
import com.todo.backend.service.Authentication.AuthenticationService;
import com.todo.backend.service.UserService.UserService;
import com.todo.backend.service.jwtTokenService.JwtRefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authentication/")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtRefreshTokenService jwtRefreshTokenService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("signup")
    public ResponseEntity<?> signup (@RequestBody User user){
        if(userService.findByUsername(user.getUsername()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }

    @PostMapping("signin")
    public ResponseEntity<?> signin(@RequestBody User user){
        return new ResponseEntity<>(authenticationService.signInAndReturnJwt(user), HttpStatus.OK);
    }

}
