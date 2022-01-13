package com.example.test_2_springboot.filters;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ControlFiltersImpl implements ControlFilters {

    CityFilters cityFilters = new CityFilters();
    //--> Date format
    SimpleDateFormat dateInput = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    //Questo metodo serve per filtrare i dat ottenuti e restituire solo
    //quelli precedenti alla data scelta dall'utente
    @Override
    public void checkData(String date) {

        System.out.println();
        System.out.println("--> Cities called before the date '" + date + "':");
        //System.out.println(cityFilters.CityNames.get(0));
        if ((cityFilters.CityNames.size()) == 0) System.out.println("--> CityNames vuoto");
        if ((cityFilters.Dates.size()) == 0) System.out.println("--> Dates vuoto");

        try {
            Date date1 = dateInput.parse(date);
            for (int i = 0; i < cityFilters.CityNames.size(); i++) {
                if (date1.before(dateInput.parse(cityFilters.getDates().get(i)))) {
                    System.out.println("--> City n°" + (i + 1) + ":" +
                            "\nDate: " + (cityFilters.Dates.get(i)) +
                            "\nName: " + (cityFilters.CityNames.get(i)));
                } else System.out.println("--> City n°" + (i + 1) + ":" +
                        "\nDate: " + (cityFilters.Dates.get(i)) +
                        "\nName: " + (cityFilters.CityNames.get(i)));
            }
        } catch (Exception e) {
            System.out.println("ERROR");
            System.out.println("--> Impossible to print the data");
            System.out.println();
        }
    }
}
