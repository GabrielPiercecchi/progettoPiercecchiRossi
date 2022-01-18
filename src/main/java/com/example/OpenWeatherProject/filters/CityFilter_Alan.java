package com.example.OpenWeatherProject.filters;

/**
 * @author Rossi Alan
 *
 */

import com.example.OpenWeatherProject.model.JSONStructure;

import java.util.ArrayList;
import java.util.Objects;

public class CityFilter_Alan {

    public ArrayList<JSONStructure> cityFiltered = new ArrayList<>();

    public void cityFilter(ArrayList<JSONStructure> jsonStructure, String cityInput) {

        if (!Objects.equals(cityInput, "all")) {

            try {
                for (JSONStructure elem : jsonStructure) {
                    if (Objects.equals(elem.getName(), cityInput)) {
                        cityFiltered.add(elem);
                    }
                }
            } catch (NullPointerException e) {
                System.out.println("Error: city data not found");
            }
        } else {
            try {
                cityFiltered.addAll(jsonStructure);
            } catch (NullPointerException e) {
                System.out.println("Error: database is empty");
            }
        }
        jsonStructure.clear();
    }

    public void printCityFiltered() {
        for(int i = 0; i < cityFiltered.size(); i++) {
            System.out.println(cityFiltered.get(i).toString());
        }
        cityFiltered.clear();
    }
}
