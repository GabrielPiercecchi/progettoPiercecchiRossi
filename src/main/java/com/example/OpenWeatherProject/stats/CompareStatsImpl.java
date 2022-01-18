package com.example.OpenWeatherProject.stats;

import com.example.OpenWeatherProject.model.JSONStructure;

import java.util.ArrayList;

import static java.lang.Math.round;

/**
 * This class implements the methods defined in the associated "CompareStats" interface
 */
public class CompareStatsImpl implements CompareStats {

    private static final double[] TCollection = new double[2];
    private static int NTemp = 0;
    private static int controlC = 0;

    /**
     * @param feels_like double variable that contains the perceived temperature of a city
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
     * This method is used as a control of the above method: "compareT"
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

    @Override
    public void tempMin(ArrayList<JSONStructure> jsonStructure) {

        double temp_min = jsonStructure.get(0).getTempMin();
        for (JSONStructure elem : jsonStructure) {
            temp_min = Math.min(temp_min, elem.getTempMin());
        }
        System.out.println("temp_min = " + temp_min + "°C");
    }

    @Override
    public void tempMax(ArrayList<JSONStructure> jsonStructure) {

        double temp_max = jsonStructure.get(0).getTempMax();
        for (JSONStructure elem : jsonStructure) {
            temp_max = Math.max(temp_max, elem.getTempMax());
        }
        System.out.println("temp_max = " + temp_max + "°C");
    }

    @Override
    public void tempMean(ArrayList<JSONStructure> jsonStructure) {

        double sum = 0;
        for (JSONStructure elem : jsonStructure) {
            sum += elem.getTemp();
        }
        double temp_mean = sum / jsonStructure.size();
        System.out.println("temp_mean = " + temp_mean + "°C");
    }

    @Override
    public void feelsLikeMean(ArrayList<JSONStructure> jsonStructure) {

        double sum = 0;
        for (JSONStructure elem : jsonStructure) {
            sum += elem.getFeelsLike();
        }
        double feels_like = sum / jsonStructure.size();
        System.out.println("feels_like_mean = " + feels_like + "°C");
    }
}
