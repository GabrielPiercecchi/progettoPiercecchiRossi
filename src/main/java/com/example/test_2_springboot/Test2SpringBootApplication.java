package com.example.test_2_springboot;

import com.example.test_2_springboot.model.City;
import com.example.test_2_springboot.service.CityService;
import com.example.test_2_springboot.service.CityServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class Test2SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Test2SpringBootApplication.class, args);
        CityService cityService = new CityServiceImpl();
        //--> Questo metodo comprende anche il MENU
        cityService.inputCity();

        /*
         Maven dependency for JSON-simple:
            <dependency>
                <groupId>com.googlecode.json-simple</groupId>
                <artifactId>json-simple</artifactId>
                <version>1.1.1</version>
            </dependency>
         */
        /*
        try {
            //Public API:
            //https://api.openweathermap.org/data/2.5/weather?q={city}&appid={KEY}
            //API KEY: 14bbc528b3c2df06e94336bd503ddc1a

            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=roma&appid=14bbc528b3c2df06e94336bd503ddc1a");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Check if connect is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();

                System.out.println(informationString);


                //JSON simple library Setup with Maven is used to convert strings to JSON
                JSONParser parse = new JSONParser();
                JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(informationString));

                //Get the first JSON object in the JSON array
                System.out.println(dataObject.get(0));

                JSONObject countryData = (JSONObject) dataObject.get(0);

                System.out.println(countryData.get("city_location:"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }
}
