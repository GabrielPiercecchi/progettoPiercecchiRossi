package com.example.OpenWeatherProject.stats;

/**
 * Questa interfaccia serve a contenere tutti i metodi che interagiscono con le variabili definite
 * nella classe "CityStats"
 */
public interface ComparativeStats {

    /**
     * Questo metodo serve per confrontare i dati salvati di due città diverse
     *
     * @param feels_like variabile double che contiene la temperatura percepita di una città
     */
    public abstract void compareT(double feels_like);

    /**
     * Questo metodo viene usato come controllo dal metodo sopra citato: "compareT"
     */
    public abstract void resetT();
}
