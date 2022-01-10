package inactiveClasses;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

public class ReaderJSONFile {

    public static int cCounter = 0;

    public static void main(String[] args) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();

        FileReader reader = new FileReader("FileCities.json");

        Object object = jsonParser.parse(reader);

        JSONObject empJsonobj = (JSONObject) object;


        String fName = (String) empJsonobj.get("Name" + (++cCounter));
        //String test = (String) empJsonobj.get("Test");
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

        JSONObject fMain = (JSONObject) empJsonobj.get("Main" + cCounter);
        double temp = Double.parseDouble(String.valueOf(fMain.get("temp" + cCounter)));
        double feels_like = Double.parseDouble(String.valueOf(fMain.get("feels_like" + cCounter)));
        double temp_min = Double.parseDouble(String.valueOf(fMain.get("temp_min" + cCounter)));
        double temp_max = Double.parseDouble(String.valueOf(fMain.get("temp_max" + cCounter)));


        System.out.println("Current kind of temperature of " + fName + ":");
        //System.out.println("--> Test: " + test);
        System.out.println("--> temp: " + temp);
        System.out.println("--> feels_like: " + feels_like);
        System.out.println("--> temp_min: " + temp_min);
        System.out.println("--> temp_max: " + temp_max);

        //--> Secondo giro

        fName = (String) empJsonobj.get("Name" + (++cCounter));

        fMain = (JSONObject) empJsonobj.get("Main" + cCounter);
        temp = Double.parseDouble(String.valueOf(fMain.get("temp" + cCounter)));
        feels_like = Double.parseDouble(String.valueOf(fMain.get("feels_like" + cCounter)));
        temp_min = Double.parseDouble(String.valueOf(fMain.get("temp_min" + cCounter)));
        temp_max = Double.parseDouble(String.valueOf(fMain.get("temp_max" + cCounter)));


        System.out.println("Current kind of temperature of " + fName + ":");
        //System.out.println("--> Test: " + test);
        System.out.println("--> temp: " + temp);
        System.out.println("--> feels_like: " + feels_like);
        System.out.println("--> temp_min: " + temp_min);
        System.out.println("--> temp_max: " + temp_max);


        reader.close();

    }
}
