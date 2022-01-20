package com.example.OpenWeatherProject.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.simple.JSONObject;

/**
 * This class contains the method used to create (or update) the Json file, which is used to save
 * the required statistics.
 */
public class CreatingJSONDocument {

    /**
     * This method is used to create (or update if it does not exist) the Json file, which is used as database to save
     * the required statistics.
     *
     * @param name          String variable that contains the name of a city.
     * @param formattedDate String variable that contains the date formatted and time the statistics are saved.
     * @param temp          double variable that contains the temperature of a city.
     * @param feels_like    double variable that contains the perceived temperature of a city.
     * @param temp_min      double variable that contains the maximum temperature of a city.
     * @param temp_max      double variable that contains the minimum temperature of a city.
     */
    public void fileWriter(String name, String formattedDate, double temp, double feels_like, double temp_min, double temp_max) {

        JSONObject citiesObj = new JSONObject();

        citiesObj.put("Name", name);
        citiesObj.put("Time", formattedDate);
        citiesObj.put("temp", temp);
        citiesObj.put("feels_like", feels_like);
        citiesObj.put("temp_min", temp_min);
        citiesObj.put("temp_max", temp_max);

        try {
            // Writing to a file
            File file = new File("FileCities.json");
            BufferedWriter bufferedWriter;

            //--> Crea il file se non esiste
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("JSON file created");
                System.out.println();
            }

            // Saving previous data to a String variable
            Path path = Paths.get("FileCities.json");
            Charset charset = StandardCharsets.UTF_8;
            String content = Files.readString(path, charset);

            bufferedWriter = new BufferedWriter(new FileWriter(new File("FileCities.json"), false));

            content = content.replaceAll("]\n", ",\n");
            bufferedWriter.write(content);
            if (file.length() == 0 && !content.contains("[")) {
                bufferedWriter.write("[");
            }
            bufferedWriter.write(citiesObj.toJSONString() + "]\n");

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("ERROR");
            System.out.println("--> File not updated");
            System.out.println();
        }
    }
}