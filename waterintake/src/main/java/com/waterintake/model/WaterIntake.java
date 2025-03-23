package com.waterintake.model;



public class WaterIntake {
    private double weight;
    private String gender;
    private boolean exercise;
    private boolean hotWeather;
    
    public WaterIntake() {}

    public WaterIntake(double weight, String gender, boolean exercise, boolean hotWeather) {
        this.weight = weight;
        this.gender = gender;
        this.exercise = exercise;
        this.hotWeather = hotWeather;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isExercise() {
        return exercise;
    }

    public void setExercise(boolean exercise) {
        this.exercise = exercise;
    }

    public boolean isHotWeather() {
        return hotWeather;
    }

    public void setHotWeather(boolean hotWeather) {
        this.hotWeather = hotWeather;
    }
}

