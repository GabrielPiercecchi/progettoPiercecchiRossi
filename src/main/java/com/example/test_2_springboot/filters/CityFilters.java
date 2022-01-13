package com.example.test_2_springboot.filters;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CityFilters {

    public ArrayList<String> Dates = new ArrayList<>();

    public ArrayList<String> CityNames = new ArrayList<>();

    public ArrayList<String> getDates() {
        return Dates;
    }

    public void setDates(ArrayList<String> dates) {
        Dates = dates;
    }

    public ArrayList<String> getCityNames() {
        return CityNames;
    }

    public void setCityNames(ArrayList<String> cityNames) {
        CityNames = cityNames;
    }

    public void addCityNames(String cityNames) {
        CityNames.add(cityNames);
    }

    public void addDates(String date) {
        Dates.add(date);
    }

    @Override
    public String toString() {
        return "CityFilters{" +
                "Dates=" + Dates +
                ", CityNames=" + CityNames +
                '}';
    }
}
