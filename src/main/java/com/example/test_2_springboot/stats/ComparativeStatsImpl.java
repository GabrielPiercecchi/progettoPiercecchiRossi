package com.example.test_2_springboot.stats;

import static java.lang.Math.round;

public class ComparativeStatsImpl implements ComparativeStats {

    static double[] TCollection = new double[2];
    static int Ntemp = 0;
    static int controllo = 0;

    @Override
    public void CompareT(double feels_like) {
        ++controllo;
        TCollection[Ntemp] = feels_like;
        if (controllo > 1) {
            if (Ntemp == 1) {
                double controller = Integer.compare((int) TCollection[Ntemp - 1], (int) TCollection[Ntemp]);
                // Output will be a value less than zero if a<b
                if (controller < 0) {
                    System.out.println("--> The second city is the hottest by " + round(TCollection[1] - TCollection[0]) + "°C");
                }
                // Output will be zero if a==b
                else if (controller == 0) {
                    System.out.println("--> Both the cities have the same temperature: " + round(feels_like - 275) + "°C");
                }
                // Output will be a value greater than zero if a>b
                else if (controller > 0) {
                    System.out.println("--> The first city is the hottest by " + round(TCollection[0] - TCollection[1]) + "°C");
                }
            }
            //--> Reset statistiche
            controllo = 0;
            Ntemp = 0;
        } else Ntemp++;
    }

    @Override
    public void ResetT() {
        System.out.println();
        System.out.println("--> Impossible to compare");
        System.out.println();
        Ntemp++;
        ++controllo;
        if (controllo > 1) {
            controllo = 0;
            Ntemp=0;
        }
    }
}
