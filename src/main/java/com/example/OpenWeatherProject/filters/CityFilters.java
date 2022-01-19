package com.example.OpenWeatherProject.filters;

import com.example.OpenWeatherProject.model.JSONStructure;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 */
public class CityFilters {

    public ArrayList<JSONStructure> cityFiltered = new ArrayList<>();

    /**
     * this method takes as parameters a JSONStructure-type ArrayList, in particular the ArrayList
     * "JSONFileManager.jsonStructure" containing deserialized data from the Json file "FileCities.json",
     * and a String variable, and filters data based on user input.
     *
     * @param jsonStructure JSONStructure-type ArrayList containing deserialized data from the Json file
     *                      "File Cities.json" through the "JSONFileManager" class
     * @param cityInput
     */
    public void cityFilter(ArrayList<JSONStructure> jsonStructure, String cityInput) {

        // the following step changes the first letter of the city name to uppercase
        String capCityInput = cityInput.substring(0, 1).toUpperCase() + cityInput.substring(1);

        if (!Objects.equals(capCityInput, "All")) {
            try {
                for (JSONStructure elem : jsonStructure) {
                    if (elem.getName().contains(capCityInput) || capCityInput.contains(elem.getName())) {
                        cityFiltered.add(elem);
                    }
                }
            } catch (NullPointerException e) {
                System.out.println("ERROR");
                System.out.println("--> City data not found");
                System.out.println();
            }
        } else {
            try {
                cityFiltered.addAll(jsonStructure);
            } catch (NullPointerException e) {
                System.out.println("ERROR");
                System.out.println("--> Empty database");
                System.out.println();
            }
        }
    }
}