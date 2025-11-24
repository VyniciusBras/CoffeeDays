package com.coffeedays.coffeedays_api.repository;

import com.coffeedays.coffeedays_api.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public UserRepository() {

        users.add(new User("adm", "ad"));
    }

    public Optional<User> findByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        users.add(user);
        return user;
    }
}
