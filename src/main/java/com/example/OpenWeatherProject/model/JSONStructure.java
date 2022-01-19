package com.example.OpenWeatherProject.model;

import java.util.Date;

/**
 * This class is used to model the Json file "FileCities.json" information deserialized by the "JSONFileManager"
 * class.
 */
public class JSONStructure {

    private String Name;
    private Date Time;
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;

    /**
     * @param name
     * @param time
     * @param temp
     * @param feels_like
     * @param temp_min
     * @param temp_max
     */
    public JSONStructure(String name, Date time, double temp, double feels_like, double temp_min, double temp_max) {
        this.Name = name;
        this.Time = time;
        this.temp = temp;
        this.feels_like = feels_like;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
    }

    /**
     * @return
     */
    public String getName() {
        return Name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.Name = name;
    }

    /**
     * @return
     */
    public double getTemp() {
        return temp;
    }

    /**
     * @param temp
     */
    public void setTemp(double temp) {
        this.temp = temp;
    }

    /**
     * @return
     */
    public double getFeelsLike() {
        return feels_like;
    }

    /**
     * @param feelsLike
     */
    public void setFeelsLike(double feelsLike) {
        this.feels_like = feelsLike;
    }

    /**
     * @return
     */
    public double getTempMin() {
        return temp_min;
    }

    /**
     * @param tempMin
     */
    public void setTempMin(double tempMin) {
        this.temp_min = tempMin;
    }

    /**
     * @return
     */
    public double getTempMax() {
        return temp_max;
    }

    /**
     * @param tempMax
     */
    public void setTempMax(double tempMax) {
        this.temp_max = tempMax;
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
        return "Call N° "+ (i+1)+" {" +
                "name = " + Name +
                ", time = " + Time +
                ", temp = " + temp + "°C" +
                ", feelsLike = " + feels_like + "°C" +
                ", tempMin = " + temp_min + "°C" +
                ", tempMax = " + temp_max + "°C" +
                '}';
    }
}