package com.example.test_2_springboot.service;

import com.example.test_2_springboot.model.City;
import com.example.test_2_springboot.utilities.CreatingJSONDocument;



import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.io.BufferedReader;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Math.round;

@Service
public class CityServiceImpl implements CityService {


    private static Map<Integer, City> cityRepo = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();
    private static HttpURLConnection connection;


    public CityServiceImpl() {
        //loading data
        City rome = new City();
        rome.setId((int) counter.incrementAndGet());
        rome.setName("Rome");
        cityRepo.put(rome.getId(), rome);

        City milan = new City();
        milan.setId((int) counter.incrementAndGet());
        milan.setName("Milan");
        cityRepo.put(milan.getId(), milan);
    }

    @Override
    public void createCity(City city) {
        if (cityRepo.containsKey(city.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Existing id...");
        }
        cityRepo.put(city.getId(), city);
    }

    @Override
    public void updateCity(Integer Id, City city) {
        cityRepo.remove(Id);
        city.setId(Id);
        cityRepo.put(Id, city);
    }

    @Override
    public void deleteCity(Integer Id) {
        cityRepo.remove(Id);
    }

    @Override
    public Collection<City> getCities() {
        return cityRepo.values();
    }

    @Override
    public void inputCity() {
        Scanner scanner = new Scanner(System.in);
        City city = new City();
        String city1;
        String city2;

        // To read File
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        //MENU
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("********************************");
        System.out.println("WELCOME TO OUR WEATHER PROGRAM!!");
        System.out.println("********************************");
        System.out.println();
        System.out.println("Description:");
        System.out.println("--------------------------------");
        System.out.println("With this program you can search and see the current temperatures of two different cities\n" +
                "and compare them!!\n" +
                "Let's begin!!\n");

        System.out.println("--> Please insert first city:");
        city1 = scanner.nextLine();
        city.setId((int) counter.incrementAndGet());
        city.setName(city1);
        cityRepo.put(city.getId(), city);

        System.out.println("--> Please insert second city:");
        city2 = scanner.nextLine();
        city.setId((int) counter.incrementAndGet());
        city.setName(city2);
        cityRepo.put(city.getId(), city);

        // Method 1: java.net.HttpURLConnection
        /*
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city1 + "&appid=" + city.getApiKey1());
            connection = (HttpURLConnection) url.openConnection();


            // Request setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Connection Control
            int status = connection.getResponseCode();
            // --> System.out.println(status);

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                System.out.println("--> Data from the first city:");
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            System.out.println(responseContent.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        System.out.println();
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city2 + "&appid=" + city.getApiKey1());
            connection = (HttpURLConnection) url.openConnection();

            // Request setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Connection Control
            int status = connection.getResponseCode();
            // --> System.out.println(status);

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                System.out.println("--> Data from the second city:");
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            System.out.println(responseContent.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        */

        // Method 2: java.net.Http.HttpClient
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request;

            request = HttpRequest.newBuilder().uri(URI.create("https://api.openweathermap.org/data/2.5/weather?q=" + city1 + "&appid=" + city.getApiKey1())).build();
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    //.thenAccept(System.out::println) --> PRINTLN FILE JSON
                    .thenApply(CityServiceImpl::parse)
                    .join();

            request = HttpRequest.newBuilder().uri(URI.create("https://api.openweathermap.org/data/2.5/weather?q=" + city2 + "&appid=" + city.getApiKey1())).build();
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(CityServiceImpl::parse)
                    .join();
        } catch (Exception e) {
            System.out.println("ERROR in the URI request");
        }
    }

    //METODO CHE "parsa" il file JSON ricevuto
    public static int Ncity=1;
    public static String parse(String responseBody) {

        try {
            CreatingJSONDocument jsonDocument = new CreatingJSONDocument();
            JSONObject obj = new JSONObject(responseBody);
            String fName = (String) obj.get("name");

            //JSONArray arr = obj.getJSONArray("main");

            double temp = obj.getJSONObject("main").getDouble("temp");
            double feels_like = obj.getJSONObject("main").getDouble("feels_like");
            double temp_min = obj.getJSONObject("main").getDouble("temp_min");
            double temp_max = obj.getJSONObject("main").getDouble("temp_max");

            jsonDocument.fileWriter(fName,temp,feels_like,temp_max,temp_min);

            System.out.println("Current temperature of " + fName + ":");
            System.out.println("--> temp: " + round((temp - 273.15)));
            System.out.println("--> feels_like: " + round((feels_like - 273.15)));
            System.out.println("--> temp_min: " + round((temp_min - 273.15)));
            System.out.println("--> temp_max: " + round((temp_max - 273.15)));
            System.out.println();

            //--> Richiamo metodo che compara le temp "feels_like" delle due città
            CompareT(feels_like);

        } catch (Exception e) {
            System.out.println();
            System.out.println("Sorry :-(\n" +
                    "--> City n° " + Ncity + " not found");
        }
        return null;
    }

    //METODO DA CORREGGERE E/O ELIMINARE
    //--> metodo SOSTITUITO con quello sottostante "CompareT"
    /*
    public static int NCity = 1;


    public static void CompareTFeels_like(Double feels_like) {
        Double[] TCollection = new Double[2];
        TCollection[NCity] = feels_like;
        NCity--;
        try {
            if (NCity == 0) {
                if (TCollection[NCity] < TCollection[NCity + 1]) {
                    System.out.println();
                    System.out.println("--> The first city is hotter");
                } else if (TCollection[NCity] > TCollection[NCity + 1]) {
                    System.out.println();
                    System.out.println("--> The second city is hotter");
                }
            }
        }catch (Exception e){
            System.out.println();
            System.out.println("--> Impossible to compare the two temperature");
        }
    }
     */

    static double[] TCollection = new double[2];
    static int Ntemp=0;
    public static void CompareT(double feels_like){
        TCollection[Ntemp]= feels_like;
        if (Ntemp==1){
            double controller = Integer.compare((int) TCollection[Ntemp-1], (int) TCollection[Ntemp]);
            // Output will be a value less than zero if a<b
            if (controller < 0){
                System.out.println("--> The second city is the hottest");
            }
            // Output will be zero if a==b
            else if (controller==0){
                System.out.println("--> Both the cities have the same temperature");
            }
            // Output will be a value greater than zero if a>b
            else if (controller>0){
                System.out.println("--> The first city is the hottest");
            }
        }
        else Ntemp++;
    }
}
