//package com.example.CarSales.controller;
//
//import com.example.CarSales.service.EmailService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class EmailTestController {
//
//    private final EmailService emailService;
//
//    public EmailTestController(EmailService emailService) {
//        this.emailService = emailService;
//    }
//
//    @GetMapping("/test-email")
//    public String testEmail() {
//        System.out.println("TEST EMAIL ENDPOINT REACHED!");
//        emailService.sendEmail(
//                "leila.omerhodzic0404@gmail.com",
//                "CarSales email test",
//                "It works! My Spring Boot application sent this email."
//        );
//
//        return "Email sent! Check your inbox.";
//    }
//}
