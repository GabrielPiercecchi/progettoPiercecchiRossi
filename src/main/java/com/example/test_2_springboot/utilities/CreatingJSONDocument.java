package com.example.test_2_springboot.utilities;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class CreatingJSONDocument {

    public static void fileWriter(String name, double temp, double feels_like, double temp_max, double temp_min) throws IOException {

        JSONObject citiesObj = new JSONObject();
        citiesObj.put("Name", name);

        JSONObject listOfTemps = new JSONObject();
        listOfTemps.put("temp",temp);
        listOfTemps.put("feels_like",feels_like);
        listOfTemps.put("temp_max",temp_max);
        listOfTemps.put("temp_min",temp_min);


        citiesObj.put("Main", listOfTemps);


        try {

            // Writing to a file
            File file=new File("FileCities.json");
            BufferedWriter bufferedWriter = null;
            if (!file.exists()){

                file.createNewFile();
                System.out.println("JSON file created:");
                System.out.println("");
            }
            //System.out.print(citiesObj);
            bufferedWriter = new BufferedWriter(new FileWriter(new File("FileCities.json"),true));
            bufferedWriter.write(citiesObj.toJSONString()+"\n");
            bufferedWriter.close();
            System.out.println("--> File updated successfully.");

        } catch (IOException e) {
            System.out.println("ERROR");
            System.out.println("--> File not updated");
            e.printStackTrace();
        }
    }
}

/*
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;


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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("JSON file created: "+jsonObject);
    }
}
*/