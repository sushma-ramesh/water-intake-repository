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

    // Show Signup Page (GET)
    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";  // Renders signup.html
    }

    // Process Signup (POST)
    @PostMapping("/signup")
    public String processSignup(@RequestParam String username,
                                @RequestParam String password) {
        userService.registerUser(username, password);
        return "redirect:/auth/login";
    }

    // Show Login Page (GET)
    @GetMapping("/login")
    public String showLoginPage(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "Invalid username or password");
        }
        return "login";  // Renders login.html
    }

    // Process Login (POST)
    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password) {
        if (userService.validateUser(username, password)) {
            return "redirect:/calculate"; // Redirect to calculation page
        } else {
            return "redirect:/auth/login?error=true"; // Redirect with error
        }
    }
}
