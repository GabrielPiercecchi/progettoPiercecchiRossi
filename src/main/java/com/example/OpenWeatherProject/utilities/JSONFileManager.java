package com.example.OpenWeatherProject.utilities;

import com.example.OpenWeatherProject.model.JSONStructure;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * This class contains the method to deserialize information saved on a Json file, and copy it into a
 * JSONStructure-type ArrayList.
 */
public class JSONFileManager {

    public static ArrayList<JSONStructure> jsonStructure = new ArrayList<>();

    /**
     * This method is for deserialize information saved on the Json file "FileCities.json", and copy it
     * automatically into the JSONStructure-type ArrayList "jsonStructure".
     */
    public static void jsonFileManager() {

        try {

            Gson gson = new GsonBuilder()
                    .setDateFormat("dd-MM-yyyy HH:mm:ss")
                    .create();

            FileReader reader = new FileReader("FileCities.json");

            Type jsonListType = new TypeToken<ArrayList<JSONStructure>>() {
            }.getType();

            jsonStructure = gson.fromJson(reader, jsonListType);
        } catch (NullPointerException | IOException e) {
            System.out.println("ERROR");
            System.out.println("--> File not deserialized");
            System.out.println();
        }
    }
}