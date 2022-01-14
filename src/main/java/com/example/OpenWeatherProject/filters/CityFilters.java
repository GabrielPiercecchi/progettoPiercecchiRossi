package com.example.OpenWeatherProject.filters;

import java.util.ArrayList;

public class CityFilters {

    protected static ArrayList<String> Dates = new ArrayList<>();
    protected static ArrayList<String> CityNames = new ArrayList<>();
    protected static ArrayList<Double> CityTemps = new ArrayList<>();
    protected static ArrayList<Double> CityFeels_like = new ArrayList<>();
    protected static ArrayList<Double> CityTemps_min = new ArrayList<>();
    protected static ArrayList<Double> CityTemps_max = new ArrayList<>();


    public void addCityNames(String cityNames) {
        CityNames.add(cityNames);
    }

    public void addDates(String date) {
        Dates.add(date);
    }

    public void addCityTemps(double cityTemps) {
        CityTemps.add(cityTemps);
    }

    public void addCityFeels_like(double cityFeels_like) {
        CityFeels_like.add(cityFeels_like);
    }

    public void addCityTemps_min(double cityTemps_min) {
        CityTemps_min.add(cityTemps_min);
    }

    public void addCityTemps_max(double cityTemps_max) {
        CityTemps_max.add(cityTemps_max);
    }

    public String toString(int i) {
        return ("City n°" + (i + 1) + ":" +
                "\n{" +
                "\n--> Date = " + (CityFilters.Dates.get(i)) +
                "\n--> Name = " + (CityFilters.CityNames.get(i)) +
                "\n--> Temp = " + (CityFilters.CityTemps.get(i)) +
                "\n--> Feels_like = " + (CityFilters.CityFeels_like.get(i)) +
                "\n--> Temp_min = " + (CityFilters.CityTemps_min.get(i)) +
                "\n--> Temp_max = " + (CityFilters.CityTemps_max.get(i)) +
                "\n}");
    }
}
