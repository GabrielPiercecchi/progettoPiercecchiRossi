package com.example.test_2_springboot.stats;

import com.example.test_2_springboot.model.City;

public class CityStats {

    City city = new City();

    private double temp;
    private double feels_like;
    private double temp_max;
    private double temp_min;

    public CityStats(double temp, double feels_like, double temp_min, double temp_max) {
        this.temp = temp;
        this.feels_like = feels_like;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    @Override
    public String toString() {
        return "{" +
                "\n--> Temp =" + temp + "°C" +
                ", \n--> Feels_like =" + feels_like + "°C" +
                ", \n--> Temp_max =" + temp_max + "°C" +
                ", \n--> Temp_min =" + temp_min + "°C" +
                "\n}";
    }
}
