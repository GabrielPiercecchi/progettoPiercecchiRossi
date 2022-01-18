package com.example.OpenWeatherProject.utilities;

import java.io.FileReader;
import java.io.IOException;

import com.example.OpenWeatherProject.model.JSONStructure;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.simple.parser.JSONParser;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * @author Rossi Alan
 */

public class JSONFileManager {

    public static ArrayList<JSONStructure> jsonStructure = new ArrayList<>();
    public static JSONStructure elem;

    public static void jsonFileManager() {

        JSONParser parser = new JSONParser();

        try {

            Gson gson = new GsonBuilder()
                    .setDateFormat("dd-MM-yyyy HH:mm:ss")
                    .create();

            FileReader reader = new FileReader("FileCities.json");

            Type jsonListType = new TypeToken<ArrayList<JSONStructure>>() {
            }.getType();

            jsonStructure = gson.fromJson(reader, jsonListType);
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }
    }
}