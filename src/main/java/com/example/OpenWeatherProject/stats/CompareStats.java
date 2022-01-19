package com.example.OpenWeatherProject.stats;

import com.example.OpenWeatherProject.model.JSONStructure;
import java.util.ArrayList;

/**
 * This interface contains all the abstract methods that are implemented in the "CompareStats" class.
 */
public interface CompareStats {

    /**
     * This method is for comparing the saved data of two different cities.
     *
     * @param feels_like double variable that contains the perceived temperature of a city.
     */
    void compareT(double feels_like);

    /**
     * This method is used as a control by the above method "compareT".
     */
    void resetT();

    void tempMin(ArrayList<JSONStructure> jsonStructure);

    void tempMax(ArrayList<JSONStructure> jsonStructure);

    void tempMean(ArrayList<JSONStructure> jsonStructure);

    void feelsLikeMean(ArrayList<JSONStructure> jsonStructure);
}