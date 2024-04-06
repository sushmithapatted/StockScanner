package com.GrowScanner.GrowScan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GrowScanner.GrowScan.model.User;
import com.GrowScanner.GrowScan.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
//hello
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
    
    public boolean validateUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        
        // Check if user with provided email exists
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            
            // Check if password matches
            if (user.getPassword().equals(password)) {
                return true; // Login successful
            }
        }
        
        return false; // Either user doesn't exist or password doesn't match
    }
}

