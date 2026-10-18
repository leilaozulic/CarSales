package com.example.CarSales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/signup")
    public String signUp() {
        return "signup";
    }

    @PostMapping("/signup")
    public String postSignUp(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("password") String password) {

        return "signup";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
