package com.example.test_2_springboot.utilities;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

public class ReaderJSONFile {

    public static void main(String[] args) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();

        FileReader reader = new FileReader(".\\JsonFile\\Cities.json");

        Object object = jsonParser.parse(reader);

        JSONObject empJsonobj = (JSONObject) object;


        String fName = (String) empJsonobj.get("name");
        /*
        String fId = (String) empJsonobj.get("id");
        String fCode = (String) empJsonobj.get("code");
        String fTimezone = (String) empJsonobj.get("cod");
        String fVisibility = (String) empJsonobj.get("visibilty");
        String fDt = (String) empJsonobj.get("dt");

        Array fCoord = (Array) empJsonobjArray.get(Integer.parseInt("coord"));
        Array fWeather = (Array) empJsonobjArray.get(Integer.parseInt("weather"));
        Array fWind = (Array) empJsonobjArray.get(Integer.parseInt("wind"));
        Array fClouds = (Array) empJsonobjArray.get(Integer.parseInt("clouds"));
        Array fSys = (Array) empJsonobjArray.get(Integer.parseInt("sys"));
         */

        JSONObject fMain = (JSONObject) empJsonobj.get("main");
        double temp = Double.parseDouble(String.valueOf(fMain.get("temp")));
        double feels_like = Double.parseDouble(String.valueOf(fMain.get("feels_like")));
        double temp_min = Double.parseDouble(String.valueOf(fMain.get("temp_min")));
        double temp_max = Double.parseDouble(String.valueOf(fMain.get("temp_max")));


        System.out.println("Current kind of temperature of " + fName + ":");
        System.out.println("--> temp: " + temp);
        System.out.println("--> feels_like: " + feels_like);
        System.out.println("--> temp_min: " + temp_min);
        System.out.println("--> temp_max: " + temp_max);


        reader.close();

    }
}
