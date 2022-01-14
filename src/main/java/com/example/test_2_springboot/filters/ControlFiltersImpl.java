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
        //--> dati ottenuti nel metodo parse classe ParseJSONDocument
        System.out.println();
        System.out.println("--> Cities called before the date '" + date + "':");
        System.out.println();
        try {
            /*
            if ((cityFilters.CityNames.size()) == 0) System.out.println("--> CityNames vuoto");
            if ((cityFilters.Dates.size()) == 0) System.out.println("--> Dates vuoto");
            if (cityFilters.CityNames.size() > 0) System.out.println("--> CityNames non vuoto");
            if (cityFilters.Dates.size() > 0) System.out.println("--> Dates non vuoto");
            */
            Date date1 = dateInput.parse(date);
            //System.out.println(date1);
            int i = 0;
            while (i < CityFilters.CityNames.size()) {
                String strCParse = CityFilters.Dates.get(i);
                Date dateCParse = dateInput.parse(strCParse);
                try {
                    if (CityFilters.CityNames.size() == 0) {
                        System.out.println("--> There are no city call :-(");
                        System.out.println();
                        break;
                    } else if (date1.after(dateCParse)) {
                        System.out.println(cityFilters.toString(i));
                        break;
                    } else {
                        System.out.println("--> There are no city call before the chosen date.");
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("ERROR");
                    System.out.println("--> Impossible to compare the dates");
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
            System.out.println("--> Impossible to print the data");
            System.out.println();
        }
    }

    //--> Salvataggio filter
    @Override
    public void addData(String date, String name, double temp, double feels_like, double temp_max, double temp_min) {
        try {
            cityFilters.addCityNames(name);
            cityFilters.addDates(date);
            cityFilters.addCityTemps(temp);
            cityFilters.addCityFeels_like(feels_like);
            cityFilters.addCityTemps_min(temp_min);
            cityFilters.addCityTemps_max(temp_max);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
            System.out.println("--> Impossible to save data in the ArrayLists");
            System.out.println();
        }
    }
}
