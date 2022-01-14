package com.example.test_2_springboot.utilities;


import com.example.test_2_springboot.filters.ControlFiltersImpl;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreatingJSONDocument {

    public static int cityCounter = 0;
    // private final AtomicLong counter = new AtomicLong();

    public void fileWriter(String name, double temp, double feels_like, double temp_min, double temp_max) throws IOException {

        //--> Serve per STATS/FILTRI su base oraria
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

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

        //--> Richiamo ArrayList per salvare nome città e data
        ControlFiltersImpl controlFilters = new ControlFiltersImpl();
        controlFilters.addData(formattedDate, name, temp, feels_like, temp_max, temp_min);

        try {

            // Writing to a file
            File file = new File("FileCities.json");
            BufferedWriter bufferedWriter;

            // Saving previous data to a String variable
            Path path = Paths.get("FileCities.json");
            Charset charset = StandardCharsets.UTF_8;
            String content = new String(Files.readAllBytes(path), charset);

            if (!file.exists()) {

                file.createNewFile();
                System.out.println("JSON file created:");
                System.out.println();
            }

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
            e.printStackTrace();
        }
    }
}

//--> Vecchia classe
/*
 public class CreatingJSONDocument {

     public static int cityCounter = 0;
     private final AtomicLong counter = new AtomicLong();

     public void fileWriter(String name, double temp, double feels_like, double temp_min, double temp_max) throws IOException {

         //--> STATS/FILTRI su base oraria
         //--> metodo da fare con attenzione (WORK IN PROGRES)

         //--> Incremento cityCounter ad ogni chiamata del metodo
         ++cityCounter;

         LocalDateTime myDateObj = LocalDateTime.now();
         DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
         String formattedDate = myDateObj.format(myFormatObj);

         JSONObject citiesObj = new JSONObject();
         citiesObj.put("Name_" + cityCounter, name);
         citiesObj.put("Time_" + cityCounter, formattedDate);

         JSONObject listOfTemps = new JSONObject();
         listOfTemps.put("temp_" + cityCounter, temp);
         listOfTemps.put("feels_like_" + cityCounter, feels_like);
         listOfTemps.put("temp_min_" + cityCounter, temp_min);
         listOfTemps.put("temp_max_" + cityCounter, temp_max);

         citiesObj.put("Main_" + cityCounter, listOfTemps);

         //ObjectMapper mapper = new ObjectMapper();//--> legato al metodo secondario sottostante

         try {
             // Writing a file
             File file = new File("FileCities.json");
             BufferedWriter bufferedWriter = null;
             if (!file.exists()) {
                 file.createNewFile();
                 System.out.println("JSON file created:");
                 System.out.println("");
             }

             /*
              //--> Metodo alternativo per la scrittura dei dati nel file JSON
             // Create JSON
             final String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(citiesObj.toJSONString());
             // Content is appended (due to StandardOpenOption.APPEND)
             Files.write(new File("FileCities.json").toPath(), Arrays.asList(json), StandardOpenOption.APPEND);
             System.out.print(citiesObj);
 /*
             bufferedWriter = new BufferedWriter(new FileWriter(new File("FileCities.json"), true));
             bufferedWriter.write(MessageFormat.format("{0}\n", citiesObj.toJSONString()));
             bufferedWriter.close();
             //System.out.println();
             //System.out.println("--> File updated successfully.");

         } catch (IOException e) {
             System.out.println("ERROR");
             System.out.println("--> File not updated");
             e.printStackTrace();
         }
     }
 }
*/

//--> Classe originaria
/*
public class CreatingJSONDocument {
    public static void main(String args[]) {

        //Creating a JSONObject object
        JSONObject jsonObject = new JSONObject();

        //Inserting key-value pairs into the json object
        jsonObject.put("ID", "1");
        jsonObject.put("First_Name", "Shikhar");
        jsonObject.put("Last_Name", "Dhawan");
        jsonObject.put("Date_Of_Birth", "1981-12-05");
        jsonObject.put("Place_Of_Birth", "Delhi");
        jsonObject.put("Country", "India");
        try {
            FileWriter file = new FileWriter(".\\JsonFile\\Cities.json");
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON file created: "+jsonObject);
    }
}
*/