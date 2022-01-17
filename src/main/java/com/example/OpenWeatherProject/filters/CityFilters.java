package com.example.OpenWeatherProject.filters;

import com.example.OpenWeatherProject.stats.CityStats;

public class CityFilters extends CityStats {

    private String date;

    /**
     * @param date       String variable that contains the date a city was called
     * @param name       String variable that contains the name of the city called
     * @param temp       double variable that contains the temperature of a city
     * @param feels_like double variable that contains the perceived temperature of a city
     * @param temp_max   double variable that contains the maximum temperature of a city
     * @param temp_min   double variable that contains the minimum temperature of a city
     */
    public CityFilters(String date, String name, double temp, double feels_like, double temp_max, double temp_min) {
        super(name, temp, feels_like, temp_max, temp_min);
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
