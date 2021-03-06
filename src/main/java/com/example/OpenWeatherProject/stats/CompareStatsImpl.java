package com.example.OpenWeatherProject.stats;

import com.example.OpenWeatherProject.model.JSONStructure;
import static java.lang.Math.round;
import java.util.ArrayList;

/**
 * This class contains the methods that deal with comparing statistical data of different cities and/or
 * periods of time.
 */
public class CompareStatsImpl implements CompareStats {

    private static final double[] TCollection = new double[2];
    private static int NTemp = 0;
    private static int controlC = 0;

    /**
     * This method is for comparing the perceived temperature of two different cities.
     *
     * @param feels_like double variable that contains the perceived temperature of a city.
     */
    @Override
    public void compareT(double feels_like) {
        controlC++;
        TCollection[NTemp] = feels_like;
        if (controlC > 1) {
            if (NTemp == 1) {
                if ((TCollection[NTemp - 1] == 200) || (TCollection[NTemp] == 200)) {
                    System.out.println("--> Impossible to compare");
                } else {
                    double controller = Integer.compare((int) TCollection[NTemp - 1], (int) TCollection[NTemp]);
                    // Output will be a value less than zero if a<b
                    if (controller < 0) {
                        System.out.println("--> The second city is the hottest by " + round(TCollection[1] - TCollection[0]) + "°C");
                    }
                    // Output will be zero if a==b
                    else if (controller == 0) {
                        System.out.println("--> Both the cities have the same temperature: " + round((feels_like - 273.15)) + "°C");
                    }
                    // Output will be a value greater than zero if a>b
                    else {
                        System.out.println("--> The first city is the hottest by " + round(TCollection[0] - TCollection[1]) + "°C");
                    }
                }
                //--> Reset statistiche
                controlC = 0;
                NTemp = 0;
            }
        } else NTemp++;
    }

    /**
     * This method is used as a control by the above method "compareT".
     */
    @Override
    public void resetT() {
        TCollection[NTemp] = 200;
        NTemp++;
        controlC++;
        if (controlC > 1) {
            controlC = 0;
            NTemp = 0;
        }
    }

    /**
     * This method calculates and prints the minimum temperature among all elements of the JSONStructure-type
     * ArrayList taken as a parameter.
     *
     * @param jsonStructure JSONStructure-type ArrayList containing all the attributes and methods of the
     *                      "JSONStructure" model-class.
     */
    @Override
    public void tempMin(ArrayList<JSONStructure> jsonStructure) {

        double temp_min = jsonStructure.get(0).getTemp_min();
        for (JSONStructure elem : jsonStructure) {
            temp_min = Math.min(temp_min, elem.getTemp_min());
        }
        System.out.println("--> The lowest Temp_min = " + temp_min + "°C");
    }

    /**
     * This method calculates and prints the maximum temperature among all elements of the JSONStructure-type
     * ArrayList taken as a parameter.
     *
     * @param jsonStructure JSONStructure-type ArrayList containing all the attributes and methods of the
     *                      "JSONStructure" model-class.
     */
    @Override
    public void tempMax(ArrayList<JSONStructure> jsonStructure) {

        double temp_max = jsonStructure.get(0).getTemp_max();
        for (JSONStructure elem : jsonStructure) {
            temp_max = Math.max(temp_max, elem.getTemp_max());
        }
        System.out.println("--> The highest Temp_max = " + temp_max + "°C");
    }

    /**
     * This method calculates and prints the average temperature among all elements of the JSONStructure-type
     * ArrayList taken as a parameter.
     *
     * @param jsonStructure JSONStructure-type ArrayList containing all the attributes and methods of the
     *                      "JSONStructure" model-class.
     */
    @Override
    public void averageTemp(ArrayList<JSONStructure> jsonStructure) {

        double sum = 0;
        for (JSONStructure elem : jsonStructure) {
            sum += elem.getTemp();
        }
        double averageTemp = sum / jsonStructure.size();
        System.out.println("--> Average_Temp = " + (double) round(averageTemp) + "°C");
    }

    /**
     *  This method calculates and prints the average perceived temperature among all elements of the
     *  JSONStructure-type ArrayList taken as a parameter.
     *
     * @param jsonStructure JSONStructure-type ArrayList containing all the attributes and methods of the
     *                      "JSONStructure" model-class.
     */
    @Override
    public void averageFeelsLike(ArrayList<JSONStructure> jsonStructure) {

        double sum = 0;
        for (JSONStructure elem : jsonStructure) {
            sum += elem.getFeels_like();
        }
        double averageFeelsLike = sum / jsonStructure.size();
        System.out.println("--> Average_Feels_like = " + (double) round(averageFeelsLike) + "°C");
    }
}