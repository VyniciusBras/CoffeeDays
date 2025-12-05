package com.coffeedays.coffeedays_api.repository.implementation;

import com.coffeedays.coffeedays_api.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserPersistenceAdapter {

    private final List<User> users = new ArrayList<>();

    public UserPersistenceAdapter() {
        users.add(new User("admin", "123456"));
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
