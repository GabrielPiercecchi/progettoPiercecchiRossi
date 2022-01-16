package com.example.OpenWeatherProject.stats;

import com.example.OpenWeatherProject.model.City;

/**
 * Questa classe serve per contenere tutte le variabili che caratterizzano una città
 */
public class CityStats {

    //City city = new City();

    private String Name;
    private double temp;
    private double feels_like;
    private double temp_max;
    private double temp_min;

    /**
     * @param name       variabile String proveniente dalla classe City
     * @param temp       variabile double che contiene la temperatura di una città
     * @param feels_like variabile double che contiene la temperatura percepita di una città
     * @param temp_max   variabile double che contiene la temperatura massima di una città
     * @param temp_min   variabile double che contiene la temperatura minima di una città
     */
    public CityStats(String name, double temp, double feels_like, double temp_max, double temp_min) {
        this.Name = name;
        this.temp = temp;
        this.feels_like = feels_like;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
    }

    /**
     * Questo metodo "getter" serve per restituire il nome di una città appena salvata
     *
     * @return restituisce il nome attuale di una città
     */
    public String getName() {
        return Name;
    }

    /**
     * Questo metodo "setter" serve per salvare il nome di una città
     *
     * @param name variabile double che contiene il nome di una città
     */
    public void setName(String name) {
        this.Name = name;
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
                " \n--> The temperature is about " + this.temp + "°C" +
                ",\n--> The perceived temperature is about " + this.feels_like + "°C" +
                ",\n--> The maximum temperature is about " + this.temp_max + "°C" +
                ",\n--> The minimum temperature is about " + this.temp_min + "°C" +
                "\n}";
    }
}