package com.example.OpenWeatherProject.model;

import com.example.OpenWeatherProject.stats.CityStats;

import java.util.Date;

/**
 * This class is used to model the Json file "FileCities.json" information deserialized by the "JSONFileManager"
 * class.
 */
public class JSONStructure extends CityStats {

    private Date Time;

    /**
     * @param name
     * @param time
     * @param temp
     * @param feels_like
     * @param temp_min
     * @param temp_max
     */
    public JSONStructure(String name, Date time, double temp, double feels_like, double temp_max, double temp_min) {
        super(name, temp, feels_like, temp_max, temp_min);
        this.Time = time;
    }

    /**
     * @return
     */
    public Date getTime() {
        return Time;
    }

    /**
     * @param time
     */
    public void setTime(Date time) {
        this.Time = time;
    }

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