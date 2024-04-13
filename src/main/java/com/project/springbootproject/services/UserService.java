package com.project.springbootproject.services;

import com.project.springbootproject.entities.User;
import com.project.springbootproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// This class provides services related to managing users.
@Service
public class UserService {
    private final UserRepository userRepository;

    // Constructor for UserService that injects the UserRepository bean.
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Retrieves all users.
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Saves a new user.
    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    // Retrieves a user by its ID.
    public User getOneUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    // Updates an existing user by its ID with the information from the provided user object.
    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        } else {
            return null;
        }
    }

    // Deletes a user by its ID.
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
