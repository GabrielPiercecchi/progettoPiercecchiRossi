package com.example.OpenWeatherProject.utilities;


import com.example.OpenWeatherProject.stats.CityStats;
import com.example.OpenWeatherProject.stats.CompareStats;
import com.example.OpenWeatherProject.stats.CompareStatsImpl;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.Math.round;

public class ParseJSONDocument {

    //METODO CHE "parsa" il file JSON ricevuto
    private static int Ncity = 0;

    public static String parse(String responseBody) {

        //--> Richiamo classe del metodo che compara le temp "feels_like"
        // delle due città dal package stats
        CompareStats compareStats = new CompareStatsImpl();

        CityStats cityStats = new CityStats(null, 0, 0, 0, 0);

        try {

            //City city = new City();
            CreatingJSONDocument jsonDocument = new CreatingJSONDocument();
            JSONObject obj = new JSONObject(responseBody);

            String fName = (String) obj.get("name");

            //JSONArray arr = obj.getJSONArray("main");

            double temp = obj.getJSONObject("main").getDouble("temp");
            double feels_like = obj.getJSONObject("main").getDouble("feels_like");
            double temp_min = obj.getJSONObject("main").getDouble("temp_min");
            double temp_max = obj.getJSONObject("main").getDouble("temp_max");

            //--> Serve per STATS/FILTRI su base oraria
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);

            //--> Salvataggio stats
            cityStats.setTemp(round((temp - 273.15)));
            cityStats.setFeels_like(round((feels_like - 273.15)));
            cityStats.setTemp_min(round((temp_min - 273.15)));
            cityStats.setTemp_max(round((temp_max - 273.15)));
            cityStats.setName(fName);
            //cityFilters.setDate(formattedDate);

            System.out.println("Current temperatures of " + fName + ":");
            //--> Println dei valori salvati
            System.out.println(cityStats);
            System.out.println();

            //--> Richiamo metodo che compara le temp "feels_like" delle due città dal package stats
            compareStats.compareT(feels_like);

            //--> Richiamo metodo che scrive su file JSON i dati ricevuti
            jsonDocument.fileWriter(cityStats.getName(), formattedDate, cityStats.getTemp(),
                    cityStats.getFeels_like(), cityStats.getTemp_min(), cityStats.getTemp_max());

            //--> Chiama classe contenente ArrayList: ControlFiltersImpl
            /*
            controlFilters.addData(cityFilters.getDate(), cityStats.getName(), cityStats.getTemp(),
                    cityStats.getFeels_like(), cityStats.getTemp_max(), cityStats.getTemp_min());
             */

            Ncity++;
        } catch (Exception e) {
            System.out.println("Sorry :-(\n" +
                    "--> City n° " + (++Ncity) + " not found");
            System.out.println();
            compareStats.resetT();
        }
        return null;
    }
}
