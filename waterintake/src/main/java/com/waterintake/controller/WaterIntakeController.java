package com.waterintake.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WaterIntakeController {
    @GetMapping("/calculate")
    public String showCalculatePage() {
        return "calculate";
    }

    @PostMapping("/calculate")
    public String processCalculation(@RequestParam double weight, @RequestParam String gender, Model model) {
        double waterIntake = gender.equals("male") ? weight * 0.04 : weight * 0.035;
        model.addAttribute("waterIntake", waterIntake);
        return "result";
    }
}
