package com.coffeedays.coffeedays_api.controllers;

import com.coffeedays.coffeedays_api.dto.LoginDto;
import com.coffeedays.coffeedays_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Object> login(@RequestBody LoginDto loginDto) {

        boolean isValid = userService.validateLogin(loginDto);

        if (isValid) {
            return ResponseEntity.ok("Login Successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login Failed");
        }
    }
}
