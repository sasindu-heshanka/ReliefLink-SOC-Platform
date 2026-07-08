package com.relieflink.user_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relieflink.user_service.model.User;
import com.relieflink.user_service.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 1. Register a new user
    public User registerUser(User user) {
        // Check if the email already exists in the database
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email is already registered!");
        }
        // Save the user to the database if the email is unique
        return userRepository.save(user);
    }

    // 2. Get user details by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}