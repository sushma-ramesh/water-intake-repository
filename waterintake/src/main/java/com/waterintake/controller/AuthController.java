package com.waterintake.controller;

import com.waterintake.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Signup Page
    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";
    }

    // Process Signup
    @PostMapping("/signup")
    public String processSignup(@RequestParam String username, @RequestParam String password) {
        userService.registerUser(username, password);
        return "redirect:/auth/login";
    }

    // Login Page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // Process Login
    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password) {
        if (userService.validateUser(username, password)) {
            return "redirect:/calculate";
        }
        return "redirect:/auth/login";
    }
}
