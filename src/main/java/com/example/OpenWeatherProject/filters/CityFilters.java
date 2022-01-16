package com.example.OpenWeatherProject.filters;

import com.example.OpenWeatherProject.stats.CityStats;

import java.util.ArrayList;

public class CityFilters extends CityStats {

    private String Date;

    /**
     * @param date       variabile String che contiene la data in cui è stata chiamata una città
     * @param name       variabile String che contiene il nome della città appena chiamata
     * @param temp       variabile double che contiene la temperatura di una città
     * @param feels_like variabile double che contiene la temperatura percepita di una città
     * @param temp_max   variabile double che contiene la temperatura massima di una città
     * @param temp_min   variabile double che contiene la temperatura minima di una città
     */
    public CityFilters(String date, String name, double temp, double feels_like, double temp_max, double temp_min) {
        super(name, temp, feels_like, temp_max, temp_min);
        this.Date = date;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }
}
