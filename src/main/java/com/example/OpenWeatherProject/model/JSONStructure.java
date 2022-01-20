package com.example.OpenWeatherProject.model;

import com.example.OpenWeatherProject.stats.CityStats;
import java.util.Date;

/**
 * This class extends the class "CityStats" (consequently it inherits its attributes and methods), and it is used
 * to model the Json file "FileCities.json" information deserialized by the "JSONFileManager" class.
 */
public class JSONStructure extends CityStats {

    private Date Time;

    /**
     * "JSONStructure" class constructor which has the purpose of initialize the instance variables.
     *
     * @param name       String variable that contains the name of a city.
     * @param time       Date variable that contains the date and time the statistics are saved.
     * @param temp       double variable that contains the temperature of a city.
     * @param feels_like double variable that contains the perceived temperature of a city.
     * @param temp_min   double variable that contains the maximum temperature of a city.
     * @param temp_max   double variable that contains the minimum temperature of a city.
     */
    public JSONStructure(String name, Date time, double temp, double feels_like, double temp_max, double temp_min) {
        super(name, temp, feels_like, temp_max, temp_min);
        this.Time = time;
    }

    /**
     * This "getter" method is used to return the date and time the statistics are saved.
     *
     * @return returns the date and time the statistics are saved.
     */
    public Date getTime() {
        return Time;
    }

    /**
     * This "setter" method is used to set the date and time the statistics are saved.
     *
     * @param time Date variable that contains the date and time the statistics are saved.
     */
    public void setTime(Date time) {
        this.Time = time;
    }

    /**
     * This "toString" method is used to return all the values defined in this class.
     *
     * @return returns all the values defined in this class.
     */
    public String toString(int i) {
        return "Call N° "+ (i + 1) +" {" +
                "name = " + getName() +
                ", time = " + getTime() +
                ", temp = " + getTemp() + "°C" +
                ", feelsLike = " + getFeels_like() + "°C" +
                ", tempMin = " + getTemp_min() + "°C" +
                ", tempMax = " + getTemp_max() + "°C" +
                '}';
    }
}