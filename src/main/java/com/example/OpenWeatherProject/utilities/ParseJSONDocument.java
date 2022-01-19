package com.example.OpenWeatherProject.utilities;

import com.example.OpenWeatherProject.stats.CityStats;
import com.example.OpenWeatherProject.stats.CompareStats;
import com.example.OpenWeatherProject.stats.CompareStatsImpl;
import org.json.JSONObject;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import static java.lang.Math.round;

/**
 *
 */
public class ParseJSONDocument {

    private static int NCity = 0;

    /**
     *
     *
     * @param responseBody
     * @return
     */
    // method that parses the received JSON file
    public static String parse(String responseBody) {

        // Creation of an instance of the class that contains the method that compares the "feels_like" values
        // of the two cities from the package "stats"
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

            // statistics saving
            cityStats.setTemp(round((temp - 273.15)));
            cityStats.setFeels_like(round((feels_like - 273.15)));
            cityStats.setTemp_min(round((temp_min - 273.15)));
            cityStats.setTemp_max(round((temp_max - 273.15)));
            cityStats.setName(fName);

            System.out.println("Current temperatures of " + fName + ":");
            // prints the previously saved values
            System.out.println(cityStats);
            System.out.println();

            // call of the method that compares the "feels_like" temps of the two cities from the "CompareStatsImpl"
            compareStats.compareT(feels_like);

            // call of the method that writes the received data to a Json file
            jsonDocument.fileWriter(cityStats.getName(), formattedDate, cityStats.getTemp(),
                    cityStats.getFeels_like(), cityStats.getTemp_min(), cityStats.getTemp_max());

            /*
            //--> Chiama classe contenente ArrayList: ControlFiltersImpl

            controlFilters.addData(cityFilters.getDate(), cityStats.getName(), cityStats.getTemp(),
                    cityStats.getFeels_like(), cityStats.getTemp_max(), cityStats.getTemp_min());
            */

            NCity++;
        } catch (Exception e) {
            System.out.println("Sorry :-(\n" +
                    "--> City n° " + (++NCity) + " not found");
            System.out.println();
            compareStats.resetT();
        }
        return null;
    }
}