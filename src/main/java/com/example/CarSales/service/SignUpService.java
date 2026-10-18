package com.example.CarSales.service;

import com.example.CarSales.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    UserRepository userRepository;

    public SignUpService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean userExistsByUsername(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public boolean userExistsByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public boolean registerUser(String username, String email, String password) {
        if (userExistsByUsername(username) || userExistsByEmail(email)) {

        }
    }
}
