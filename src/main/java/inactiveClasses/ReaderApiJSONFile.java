package inactiveClasses;

import com.example.test_2_springboot.service.CityService;
import com.example.test_2_springboot.service.CityServiceImpl;
import org.json.JSONArray;
import org.json.JSONObject;


public class ReaderApiJSONFile {

    /*
    CityService inputCity = new CityServiceImpl();

    public static String parse(String responseBody){
        JSONArray citiesAttributes = new JSONArray(responseBody);
        for(int i=0;i< citiesAttributes.length();i++){
            JSONObject cityAttributes = citiesAttributes.getJSONObject(i);
            org.json.simple.JSONObject fMain = (org.json.simple.JSONObject) cityAttributes.get("main");
            double temp = Double.parseDouble(String.valueOf(fMain.get("temp")));
            double feels_like = Double.parseDouble(String.valueOf(fMain.get("feels_like")));
            double temp_min = Double.parseDouble(String.valueOf(fMain.get("temp_min")));
            double temp_max = Double.parseDouble(String.valueOf(fMain.get("temp_max")));
        }
        return null;
    }
    */
}
