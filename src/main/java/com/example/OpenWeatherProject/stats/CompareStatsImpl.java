package com.example.OpenWeatherProject.stats;

import static java.lang.Math.round;

/**
 * Questa classe implementa i metodo definiti nell'interfaccia "ComparativeStats" associata
 */
public class CompareStatsImpl implements CompareStats {

    static double[] TCollection = new double[2];
    static int NTemp = 0;
    static int controlC = 0;

    /**
     * @param feels_like variabile double che contiene la temperatura percepita di una città
     */
    @Override
    public void compareT(double feels_like) {
        controlC++;
        TCollection[NTemp] = feels_like;
        if (controlC > 1) {
            if (NTemp == 1) {
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
                else if (controller > 0) {
                    System.out.println("--> The first city is the hottest by " + round(TCollection[0] - TCollection[1]) + "°C");
                }
            }
            //--> Reset statistiche
            controlC = 0;
            NTemp = 0;
        } else NTemp++;
    }

    /**
     * Questo metodo viene usato come controllo dal metodo sopra citato: "compareT"
     */
    @Override
    public void resetT() {
        System.out.println();
        System.out.println("--> City not found: impossible to compare");
        System.out.println();
        NTemp++;
        ++controlC;
        if (controlC > 1) {
            controlC = 0;
            NTemp = 0;
        }
    }
}
