package com.example.test_2_springboot.utilities;

import com.example.test_2_springboot.filters.CityFilters;
import com.example.test_2_springboot.filters.ControlFilters;
import com.example.test_2_springboot.filters.ControlFiltersImpl;
import com.example.test_2_springboot.stats.CityStats;
import com.example.test_2_springboot.stats.ComparativeStats;
import com.example.test_2_springboot.stats.ComparativeStatsImpl;
import com.example.test_2_springboot.utilities.CreatingJSONDocument;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Math.round;

public class ParseJSONDocument {

    //METODO CHE "parsa" il file JSON ricevuto
    public static int Ncity = 0;

    public static String parse(String responseBody) {

        //--> Richiamo metodo che compara le temp "feels_like" delle due città dal package stats
        ComparativeStats comparativeStats = new ComparativeStatsImpl();

        try {
            CityStats cityStats = new CityStats(0, 0, 0, 0);
            //City city = new City();
            CreatingJSONDocument jsonDocument = new CreatingJSONDocument();
            JSONObject obj = new JSONObject(responseBody);

            String fName = (String) obj.get("name");

            //JSONArray arr = obj.getJSONArray("main");

            double temp = obj.getJSONObject("main").getDouble("temp");
            double feels_like = obj.getJSONObject("main").getDouble("feels_like");
            double temp_min = obj.getJSONObject("main").getDouble("temp_min");
            double temp_max = obj.getJSONObject("main").getDouble("temp_max");

            //--> Salvataggio stats
            cityStats.setTemp(round((temp - 273.15)));
            cityStats.setFeels_like(round((feels_like - 273.15)));
            cityStats.setTemp_min(round((temp_min - 273.15)));
            cityStats.setTemp_max(round((temp_max - 273.15)));

            System.out.println("Current temperature of " + fName + ":");
            //--> Println dei valori salvati
            System.out.println(cityStats);
            System.out.println();

            /*
            System.out.println("--> temp: " + round((temp - 273.15)));
            System.out.println("--> feels_like: " + round((feels_like - 273.15)));
            System.out.println("--> temp_min: " + round((temp_min - 273.15)));
            System.out.println("--> temp_max: " + round((temp_max - 273.15)));
            */

            //--> Richiamo metodo che compara le temp "feels_like" delle due città dal package stats
            //ComparativeStats comparativeStats = new ComparativeStatsImpl();
            comparativeStats.CompareT(feels_like);

            //--> Richiamo metodo che scrive su file JSON i dati ricevuti
            jsonDocument.fileWriter(fName, cityStats.getTemp(), cityStats.getFeels_like(), cityStats.getTemp_min(), cityStats.getTemp_max());

            Ncity++;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Sorry :-(\n" +
                    "--> City n° " + (++Ncity) + " not found");
            comparativeStats.ResetT();
        }
        return null;
    }
}
