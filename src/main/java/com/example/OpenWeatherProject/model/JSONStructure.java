package com.example.OpenWeatherProject.model;

import java.util.Date;

/**
 * @author Rossi Alan
 *
 */

public class JSONStructure {

    private String name;
    private Date time;
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;

    /**
     *
     * @param name
     * @param time
     * @param temp
     * @param feels_like
     * @param temp_min
     * @param temp_max
     */
    public JSONStructure(String name, Date time, double temp, double feels_like, double temp_min, double temp_max) {
        this.name = name;
        this.time = time;
        this.temp = temp;
        this.feels_like = feels_like;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public double getTemp() {
        return temp;
    }

    /**
     *
     * @param temp
     */
    public void setTemp(double temp) {
        this.temp = temp;
    }

    /**
     *
     * @return
     */
    public double getFeelsLike() {
        return feels_like;
    }

    /**
     *
     * @param feelsLike
     */
    public void setFeelsLike(double feelsLike) {
        this.feels_like = feelsLike;
    }

    /**
     *
     * @return
     */
    public double getTempMin() {
        return temp_min;
    }

    /**
     *
     * @param tempMin
     */
    public void setTempMin(double tempMin) {
        this.temp_min = tempMin;
    }

    /**
     *
     * @return
     */
    public double getTempMax() {
        return temp_max;
    }

    /**
     *
     * @param tempMax
     */
    public void setTempMax(double tempMax) {
        this.temp_max = tempMax;
    }

    /**
     *
     * @return
     */
    public Date getTime() {
        return time;
    }

    /**
     *
     * @param time
     */
    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "JSONStructure{" +
                "name = " + name +
                ", time = " + time +
                ", temp = " + temp + "°C" +
                ", feelsLike = " + feels_like + "°C" +
                ", tempMin = " + temp_min + "°C" +
                ", tempMax = " + temp_max + "°C" +
                '}';
    }
}