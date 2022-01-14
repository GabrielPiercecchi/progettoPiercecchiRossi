package com.example.test_2_springboot.stats;

import com.example.test_2_springboot.model.City;

/**
 * Questa classe serve per contenere tutte le variabile che caratterizzano una città
 */
public class CityStats {

    City city = new City();


    private double temp;
    private double feels_like;
    private double temp_max;
    private double temp_min;

    /**
     *
     * @param temp variabile double che contiene la temperatura di una città
     * @param feels_like variabile double che contiene la temperatura percepita di una città
     * @param temp_max variabile double che contiene la temperatura massima di una città
     * @param temp_min variabile double che contiene la temperatura minima di una città
     */
    public CityStats(double temp, double feels_like, double temp_max, double temp_min) {
        this.temp = temp;
        this.feels_like = feels_like;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
    }

    /**
     * Questo metodo "getter" serve per restituire la temperatura di una città
     *
     * @return restituisce la temperatura attuale di una città
     */
    public double getTemp() {
        return temp;
    }

    /**
     * Questo metodo "setter" serve per salvare la temperatura di una città
     *
     * @param temp variabile double che contiene la temperatura di una città
     */
    public void setTemp(double temp) {
        this.temp = temp;
    }

    /**
     * Questo metodo "getter" serve per restituire la temperatura percepita di una città
     *
     * @return restituisce la temperatura percepita di una città
     */
    public double getFeels_like() {
        return feels_like;
    }

    /**
     * Questo metodo "setter" serve per salvare la temperatura percepita di una città
     *
     * @param feels_like variabile double che contiene la temperatura percepita di una città
     */
    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    /**
     * Questo metodo "getter" serve per restituire la temperatura massima di una città
     *
     * @return restituisce la temperatura massima di una città
     */
    public double getTemp_max() {
        return temp_max;
    }

    /**
     * Questo metodo "setter" serve per salvare la temperatura massima di una città
     *
     * @param temp_max variabile double che contiene la temperatura massima di una città
     */
    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    /**
     * Questo metodo "getter" serve per restituire la temperatura minima di una città
     *
     * @return restituisce la temperatura minima di una città
     */
    public double getTemp_min() {
        return temp_min;
    }

    /**
     * Questo metodo "setter" serve per salvare la temperatura minima di una città
     *
     * @param temp_min variabile double che contiene la temperatura minima di una città
     */
    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    /**
     * Questo metodo "toString" serve per restituire tutti i valori, definiti in questa classe, appena salvati
     *
     * @return restituisce tutti i valori, definiti in questa classe, appena salvati
     */
    @Override
    public String toString() {
        return "{" +
                "\n--> Temp = " + temp + "°C" +
                ", \n--> Feels_like = " + feels_like + "°C" +
                ", \n--> Temp_max = " + temp_max + "°C" +
                ", \n--> Temp_min = " + temp_min + "°C" +
                "\n}";
    }
}
