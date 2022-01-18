package com.example.OpenWeatherProject.stats;

import com.example.OpenWeatherProject.model.JSONStructure;

import java.util.ArrayList;

/**
 * Questa interfaccia serve a contenere tutti i metodi che interagiscono con le variabili definite
 * nella classe "CityStats"
 */
public interface CompareStats {

    /**
     * Questo metodo serve per confrontare i dati salvati di due città diverse
     *
     * @param feels_like variabile double che contiene la temperatura percepita di una città
     */
    void compareT(double feels_like);

    /**
     * Questo metodo viene usato come controllo dal metodo sopra citato: "compareT"
     */
    void resetT();

    void tempMin(ArrayList<JSONStructure> jsonStructure);

    void tempMax(ArrayList<JSONStructure> jsonStructure);

    void tempMean(ArrayList<JSONStructure> jsonStructure);

    void feelsLikeMean(ArrayList<JSONStructure> jsonStructure);
}
