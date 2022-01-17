package com.example.OpenWeatherProject.utilities;


import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingJSONDocument {

    private int cityCounter = 0;
    // private final AtomicLong counter = new AtomicLong();

    public void fileWriter(String name, String formattedDate, double temp, double feels_like, double temp_min, double temp_max) throws IOException {

        JSONObject citiesObj = new JSONObject();
        citiesObj.put("Call N°", ++cityCounter);
        citiesObj.put("Name", name);
        citiesObj.put("Time", formattedDate);

        JSONObject listOfTemps = new JSONObject();
        listOfTemps.put("temp", temp);
        listOfTemps.put("feels_like", feels_like);
        listOfTemps.put("temp_min", temp_min);
        listOfTemps.put("temp_max", temp_max);

        citiesObj.put("Main", listOfTemps);
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
            String content = new String(Files.readAllBytes(path), charset);

            bufferedWriter = new BufferedWriter(new FileWriter(new File("FileCities.json"), false));

            content = content.replaceAll("]\n", ",\n");
            bufferedWriter.write(content);
            if (file.length() == 0 && !content.contains("[")) bufferedWriter.write("[");
            bufferedWriter.write(citiesObj.toJSONString() + "]\n");

            bufferedWriter.close();
            //System.out.println("--> File updated successfully.");
        } catch (IOException e) {
            System.out.println("ERROR");
            System.out.println("--> File not updated");
            System.out.println();
        }
    }
}