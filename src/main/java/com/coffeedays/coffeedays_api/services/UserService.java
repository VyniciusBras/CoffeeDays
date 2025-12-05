package com.coffeedays.coffeedays_api.services;

import com.coffeedays.coffeedays_api.dto.LoginDto;
import com.coffeedays.coffeedays_api.models.User;

import com.coffeedays.coffeedays_api.repository.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    //@Autowired
    //private UserRepository userRepository;

    public boolean validateLogin(LoginDto loginDto) {
        /*Optional<User> userOptional = userRepository.findByUsername(loginDto.getUsername());

        if (userOptional.isEmpty()) return false;

        User user = userOptional.get();
        return user.getPassword().equals(loginDto.getPassword());*/
        return true;
    }
}
