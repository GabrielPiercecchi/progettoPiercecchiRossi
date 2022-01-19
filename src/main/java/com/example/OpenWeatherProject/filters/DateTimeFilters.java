package com.example.OpenWeatherProject.filters;

import com.example.OpenWeatherProject.model.JSONStructure;

import java.util.ArrayList;

public interface DateTimeFilters {

    void dateTimeFilter(ArrayList<JSONStructure> jsonStructure, String startStringDateTime,
                               String endStringDateTime);

    void printDateTimeFiltered();
}