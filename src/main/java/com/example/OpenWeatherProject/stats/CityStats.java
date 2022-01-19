package com.example.OpenWeatherProject.stats;

/**
 * This class is used to define all the attributes that characterize the statistics concerning the temperature
 * of a city.
 */
public class CityStats {

    private String Name;
    private double temp;
    private double feels_like;
    private double temp_max;
    private double temp_min;

    /**
     * @param name       String variable that contains the name of a city.
     * @param temp       double variable that contains the temperature of a city.
     * @param feels_like double variable that contains the perceived temperature of a city.
     * @param temp_max   double variable that contains the maximum temperature of a city.
     * @param temp_min   double variable that contains the minimum temperature of a city.
     */
    public CityStats(String name, double temp, double feels_like, double temp_max, double temp_min) {
        this.Name = name;
        this.temp = temp;
        this.feels_like = feels_like;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
    }

    /**
     * This "getter" method is used to return the name of a city.
     *
     * @return returns the current name of a city.
     */
    public String getName() {
        return Name;
    }

    /**
     * This "setter" method is used to set the name of a city.
     *
     * @param name double variable that contains the name of a city.
     */
    public void setName(String name) {
        this.Name = name;
    }

    /**
     * This "getter" method is used to return the temperature of a city.
     *
     * @return returns the current temperature of a city.
     */
    public double getTemp() {
        return temp;
    }

    /**
     * This "setter" method is used to set the temperature of a city.
     *
     * @param temp double variable that contains the temperature of a city.
     */
    public void setTemp(double temp) {
        this.temp = temp;
    }

    /**
     * This "getter" method is used to return the perceived temperature of a city.
     *
     * @return returns the perceived temperature of a city.
     */
    public double getFeels_like() {
        return feels_like;
    }

    /**
     * This "setter" method is used to set the perceived temperature of a city.
     *
     * @param feels_like double variable that contains the perceived temperature of a city.
     */
    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    /**
     * This "getter" method is used to return the maximum temperature of a city.
     *
     * @return returns the maximum temperature of a city.
     */
    public double getTemp_max() {
        return temp_max;
    }

    /**
     * This "setter" method is used to set the maximum temperature of a city.
     *
     * @param temp_max double variable that contains the maximum temperature of a city.
     */
    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    /**
     * This "getter" method is used to return the minimum temperature of a city.
     *
     * @return returns the minimum temperature of a city.
     */
    public double getTemp_min() {
        return temp_min;
    }

    /**
     * This "setter" method is used to set the minimum temperature of a city.
     *
     * @param temp_min double variable that contains the minimum temperature of a city.
     */
    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    /**
     * This "toString" method is used to return all the values defined in this class.
     *
     * @return returns all the values defined in this class.
     */
    public String toString() {
        return "{" +
                " \n--> The temperature is " + this.temp + "°C" +
                ",\n--> The perceived temperature is " + this.feels_like + "°C" +
                ",\n--> The maximum temperature is " + this.temp_max + "°C" +
                ",\n--> The minimum temperature is " + this.temp_min + "°C" +
                "\n}";
    }
}