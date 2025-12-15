package com.coffeedays.coffeedays_api.services;

import com.coffeedays.coffeedays_api.dto.LoginDto;

import org.springframework.stereotype.Service;

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
