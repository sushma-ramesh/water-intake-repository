package com.waterintake.service;



import com.waterintake.model.WaterIntake;
import org.springframework.stereotype.Service;

@Service
public class WaterIntakeService {

    public double calculateWaterIntake(WaterIntake waterIntake) {
        double waterIntakeAmount;
        if (waterIntake.getGender().equalsIgnoreCase("male")) {
            waterIntakeAmount = waterIntake.getWeight() * 35; // 35mL per kg
        } else {
            waterIntakeAmount = waterIntake.getWeight() * 31; // 31mL per kg
        }

        // Additional adjustments
        if (waterIntake.isExercise()) {
            waterIntakeAmount += 500; // Add 500mL for exercise
        }
        if (waterIntake.isHotWeather()) {
            waterIntakeAmount += 500; // Add 500mL for hot weather
        }

        return waterIntakeAmount / 1000; // Convert to liters
    }
}

