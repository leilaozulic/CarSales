package com.example.CarSales.service;

import com.example.CarSales.entity.EmailVerificationToken;
import com.example.CarSales.entity.User;
import com.example.CarSales.enums.RegistrationStatus;
import com.example.CarSales.enums.UserStatus;
import com.example.CarSales.repository.EmailVerificationTokenRepository;
import com.example.CarSales.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SignUpService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailVerificationTokenRepository emailVerificationTokenRepository;
    private final VerificationTokenService verificationTokenService;
    private final EmailService emailService;


    public SignUpService(UserRepository userRepository, PasswordEncoder passwordEncoder, EmailVerificationTokenRepository emailVerificationTokenRepository, VerificationTokenService verificationTokenService, EmailService emailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailVerificationTokenRepository = emailVerificationTokenRepository;
        this.verificationTokenService = verificationTokenService;
        this.emailService = emailService;
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

        String token = verificationTokenService.generateToken();
        String tokenHash = verificationTokenService.hashToken(token);

        EmailVerificationToken verificationToken = new EmailVerificationToken(tokenHash, newUser, LocalDateTime.now().plusHours(24));
        emailVerificationTokenRepository.save(verificationToken);
        emailService.sendVerificationEmail(email, token);

        return RegistrationStatus.SUCCESS;
    }
}
