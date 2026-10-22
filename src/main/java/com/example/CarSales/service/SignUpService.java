package com.example.CarSales.service;

import com.example.CarSales.entity.User;
import com.example.CarSales.enums.RegistrationStatus;
import com.example.CarSales.enums.UserStatus;
import com.example.CarSales.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public SignUpService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean userExistsByUsername(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public boolean userExistsByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public RegistrationStatus registerUser(String username, String email, String password) {
        if (userExistsByUsername(username)) {
            return RegistrationStatus.USERNAME_EXISTS;
        } else if (userExistsByEmail(email)) {
            return RegistrationStatus.EMAIL_EXISTS;
        }
        String hashedPassword = passwordEncoder.encode(password);
        User newUser = new User(username, email, hashedPassword, UserStatus.UNAPPROVED);
        userRepository.save(newUser);

        return RegistrationStatus.SUCCESS;
    }
}
