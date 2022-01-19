package com.example.OpenWeatherProject.filters;

import com.example.OpenWeatherProject.model.JSONStructure;
import java.util.ArrayList;

/**
 *
 */
public interface DateTimeFilters {

    /**
     * This method filters data present on the JSONStructure-type ArrayList "cityFiltered", afterwards passed
     * as a parameter to the method, in the time range defined by the two String variables (subsequently converted
     * to Date variables) startStringDateTime and endStringDateTime.
     *
     * @param jsonStructure JSONStructure-type ArrayList containing data filtered by the "CityFilters" class
     * @param startStringDateTime String variable that contains the name of the first city.
     * @param endStringDateTime String variable that contains the name of the first city.
     */
    void dateTimeFilter(ArrayList<JSONStructure> jsonStructure, String startStringDateTime, String endStringDateTime);

    /**
     * This method prints filtered data to the terminal.
     */
    void printDateTimeFiltered();
}