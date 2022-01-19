package com.example.OpenWeatherProject.stats;

import com.example.OpenWeatherProject.model.JSONStructure;
import java.util.ArrayList;

/**
 * This interface contains all the methods that are implemented in the "CompareStatsImpl" class.
 */
public interface CompareStats {

    /**
     * This method is for comparing the perceived temperature of two different cities.
     *
     * @param feels_like double variable that contains the perceived temperature of a city.
     */
    void compareT(double feels_like);

    /**
     * This method is used as a control by the above method "compareT".
     */
    void resetT();

    /**
     * This method calculates and prints the minimum temperature among all elements of the JSONStructure-type
     * ArrayList taken as a parameter.
     *
     * @param jsonStructure JSONStructure-type ArrayList containing all the attributes and methods of the
     *                      "JSONStructure" model-class.
     */
    void tempMin(ArrayList<JSONStructure> jsonStructure);

    /**
     * This method calculates and prints the maximum temperature among all elements of the JSONStructure-type
     * ArrayList taken as a parameter.
     *
     * @param jsonStructure JSONStructure-type ArrayList containing all the attributes and methods of the
     *                      "JSONStructure" model-class.
     */
    void tempMax(ArrayList<JSONStructure> jsonStructure);

    /**
     * This method calculates and prints the average temperature among all elements of the JSONStructure-type
     * ArrayList taken as a parameter.
     *
     * @param jsonStructure JSONStructure-type ArrayList containing all the attributes and methods of the
     *                      "JSONStructure" model-class.
     */
    void averageTemp(ArrayList<JSONStructure> jsonStructure);

    /**
     *  This method calculates and prints the average perceived temperature among all elements of the
     *  JSONStructure-type ArrayList taken as a parameter.
     *
     * @param jsonStructure JSONStructure-type ArrayList containing all the attributes and methods of the
     *                      "JSONStructure" model-class.
     */
    void averageFeelsLike(ArrayList<JSONStructure> jsonStructure);
}