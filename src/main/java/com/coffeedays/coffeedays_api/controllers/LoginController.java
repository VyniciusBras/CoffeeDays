package com.coffeedays.coffeedays_api.controllers;

import com.coffeedays.coffeedays_api.dto.LoginDto;
import com.coffeedays.coffeedays_api.services.JwtService;
import com.coffeedays.coffeedays_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public LoginController(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Object> login(@RequestBody LoginDto loginDto) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
        );

        String token = jwtService.generateToken(loginDto.getUsername());
        return ResponseEntity.ok(Map.of("token", token));

    }
}
