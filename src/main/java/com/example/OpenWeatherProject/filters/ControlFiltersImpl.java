package com.example.OpenWeatherProject.filters;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ControlFiltersImpl implements ControlFilters {

    //--> Date format
    SimpleDateFormat dateInput = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    private static final ArrayList<CityFilters> cityFiltersArrayList = new ArrayList<>();

    //Questo metodo serve per filtrare i dat ottenuti e restituire solo
    //quelli precedenti alla data scelta dall'utente
    @Override
    public void checkData(String date) {
        //--> dati ottenuti nel metodo parse classe ParseJSONDocument
        System.out.println();
        System.out.println("--> Cities called before the date '" + date + "':");
        System.out.println();
        try {

            //if ((cityFiltersArrayList.size()) == 0) System.out.println("--> CityNames vuoto");
            //if ((cityFiltersArrayList.size()) == 0) System.out.println("--> Dates vuoto");
            //if (cityFiltersArrayList.size() > 0) System.out.println("--> CityNames non vuoto");
            //if (cityFiltersArrayList.size() > 0) System.out.println("--> Dates non vuoto");

            //--> Converto da String a Date la data ricevuta (date)
            Date Date1 = dateInput.parse(date);
            //System.out.println(Date);

            int i = 0;
            while (i < cityFiltersArrayList.size()) {
                String strCParse = cityFiltersArrayList.get(i).getDate();
                Date dateCParse = dateInput.parse(strCParse);
                try {
                    if (Date1.after(dateCParse)) {
                        System.out.println(toString(i));
                        System.out.println();
                    } else {
                        System.out.println("--> There are no more city call before the chosen date");
                        System.out.println();
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("ERROR");
                    System.out.println("--> Impossible to compare the dates");
                }
                i++;
            }
        } catch (Exception e) {
            System.out.println("ERROR");
            System.out.println("--> Impossible to print the data");
            System.out.println();
        }
    }

    //--> Salvataggio filter
    @Override
    public void addData(String date, String name, double temp, double feels_like,
                        double temp_max, double temp_min) {
        try {
            cityFiltersArrayList.add(new CityFilters(date, name, temp, feels_like, temp_max, temp_min));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
            System.out.println("--> Impossible to save data using ArrayList");
            System.out.println();
        }
    }

    @Override
    public String toString(int i) {
        return ("City n°" + (i + 1) + ":" +
                "\n{" +
                "\n--> Date = " + (cityFiltersArrayList.get(i).getDate()) +
                "\n--> Name = " + (cityFiltersArrayList.get(i).getName()) +
                "\n--> Temp = " + (cityFiltersArrayList.get(i).getTemp()) +
                "\n--> Feels_like = " + (cityFiltersArrayList.get(i).getFeels_like()) +
                "\n--> Temp_min = " + (cityFiltersArrayList.get(i).getTemp_min()) +
                "\n--> Temp_max = " + (cityFiltersArrayList.get(i).getTemp_max()) +
                "\n}");
    }
}
