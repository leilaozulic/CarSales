package com.example.CarSales.controller;

import com.example.CarSales.entity.EmailVerificationToken;
import com.example.CarSales.entity.User;
import com.example.CarSales.enums.UserStatus;
import com.example.CarSales.repository.EmailVerificationTokenRepository;
import com.example.CarSales.repository.UserRepository;
import com.example.CarSales.service.VerificationTokenService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class EmailController {

    private final EmailVerificationTokenRepository tokenRepository;
    private final VerificationTokenService tokenService;
    private final UserRepository userRepository;

    public EmailController(
            EmailVerificationTokenRepository tokenRepository,
            VerificationTokenService tokenService,
            UserRepository userRepository) {
        this.tokenRepository = tokenRepository;
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @GetMapping("/verify-email")
    public String showConfirmation(
            @RequestParam String token,
            Model model) {

        model.addAttribute("token", token);
        return "verifyEmailConfirmation";
    }

    @PostMapping("/verify-email")
    @ResponseBody
    @Transactional
    public String verifyEmail(@RequestParam String token) {

        String tokenHash = tokenService.hashToken(token);

        EmailVerificationToken verificationToken =
                tokenRepository.findById(tokenHash).orElse(null);

        if (verificationToken == null) {
            return "Invalid verification link.";
        }

        if (verificationToken.getExpiresAt()
                .isBefore(LocalDateTime.now())) {
            tokenRepository.delete(verificationToken);
            return "This verification link has expired. Please request a new one.";
        }

        User user = verificationToken.getUser();
        user.setStatus(UserStatus.ACTIVE);

        userRepository.save(user);
        tokenRepository.delete(verificationToken);

        return "Your email has been verified! Your CarSales account is now active.";
    }
}
