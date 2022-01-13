package com.example.test_2_springboot.filters;

import com.example.test_2_springboot.utilities.ParseJSONDocument;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ControlFiltersImpl implements ControlFilters {

    CityFilters cityFilters;
    //--> Date format
    SimpleDateFormat dateInput = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    //Questo metodo serve per filtrare i dat ottenuti e restituire solo
    //quelli precedenti alla data scelta dall'utente
    @Override
    public void checkData(String date) {
        //--> dati ottenuti nel metodo parse classe ParseJSONDocument

        System.out.println();
        System.out.println("--> Cities called before the date '" + date + "':");

        try {
            if ((cityFilters.CityNames.size()) == 0) System.out.println("--> CityNames vuoto");
            if ((cityFilters.Dates.size()) == 0) System.out.println("--> Dates vuoto");

            if (cityFilters.CityNames.size() > 0)  System.out.println("--> CityNames non vuoto");
            if (cityFilters.Dates.size() > 0)  System.out.println("--> Dates non vuoto");

            Date date1 = dateInput.parse(date);
            System.out.println(date1);
            int i = 0;
            while (i < cityFilters.getCityNames().size()) {
                if (date1.before(dateInput.parse(cityFilters.getDates().get(i)))) {
                    System.out.println("--> City n°" + (i + 1) + ":" +
                            "\nDate: " + (cityFilters.Dates.get(i)) +
                            "\nName: " + (cityFilters.CityNames.get(i)));
                } else System.out.println("--> City n°" + (i + 1) + ":" +
                        "\nDate: " + (cityFilters.Dates.get(i)) +
                        "\nName: " + (cityFilters.CityNames.get(i)));
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
            System.out.println("--> Impossible to print the data");
            System.out.println();
        }
    }
}
