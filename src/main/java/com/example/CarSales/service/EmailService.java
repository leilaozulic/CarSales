package com.example.CarSales.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    public EmailService(
            JavaMailSender mailSender,
            TemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    public void sendVerificationEmail(String to, String token) {
        String verificationUrl =
                "http://localhost:8080/verify-email?token=" + token;

        // Pass variables to the HTML template
        Context context = new Context();
        context.setVariable("verificationUrl", verificationUrl);

        // Process templates/email-verification.html
        String htmlContent = templateEngine.process(
                "email-verification",
                context
        );

        // Create and send the HTML email
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper =
                    new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject("Verify your CarSales email");
            helper.setText(htmlContent, true);

            mailSender.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(
                    "Failed to create verification email", e);
        }
    }
}
