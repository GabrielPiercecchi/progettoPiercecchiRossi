package com.example.test_2_springboot.service;

import com.example.test_2_springboot.model.City;
import com.example.test_2_springboot.stats.CityStats;
import com.example.test_2_springboot.stats.ComparativeStats;
import com.example.test_2_springboot.stats.ComparativeStatsImpl;
import com.example.test_2_springboot.utilities.CreatingJSONDocument;


import com.example.test_2_springboot.utilities.ParseJSONDocument;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.io.BufferedReader;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.StringCharacterIterator;
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
    public void inputCity(String city1, String city2) {

        City city = new City();
        City cityI = new City();
        City cityII = new City();

        //--> Set city1
        cityI.setId((int) counter.incrementAndGet());
        cityI.setName(city1);
        cityRepo.put(cityI.getId(), cityI);
        //--> Set city2
        cityII.setId((int) counter.incrementAndGet());
        cityII.setName(city2);
        cityRepo.put(cityII.getId(), cityII);

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

            request = HttpRequest.newBuilder().uri(URI.create("https://api.openweathermap.org/data/2.5/weather?q=" + city1 + "&appid=" + "14bbc528b3c2df06e94336bd503ddc1a")).build();
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    //.thenAccept(System.out::println) --> PRINTLN FILE JSON
                    .thenApply(ParseJSONDocument::parse)
                    .join();

            request = HttpRequest.newBuilder().uri(URI.create("https://api.openweathermap.org/data/2.5/weather?q=" + city2 + "&appid=" + "14bbc528b3c2df06e94336bd503ddc1a")).build();
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(ParseJSONDocument::parse)
                    .join();
        } catch (Exception e) {
            System.out.println("ERROR in the URI request");
        }
    }

    //--> Metodo spostato nel package "stats" nell'interfaccia "ComparativeStats"
    /*
    static double[] TCollection = new double[2];
    static int Ntemp = 0;

    public static void CompareT(double feels_like) {
        TCollection[Ntemp] = feels_like;
        if (Ntemp == 1) {
            double controller = Integer.compare((int) TCollection[Ntemp - 1], (int) TCollection[Ntemp]);
            // Output will be a value less than zero if a<b
            if (controller < 0) {
                System.out.println("--> The second city is the hottest");
            }
            // Output will be zero if a==b
            else if (controller == 0) {
                System.out.println("--> Both the cities have the same temperature");
            }
            // Output will be a value greater than zero if a>b
            else if (controller > 0) {
                System.out.println("--> The first city is the hottest");
            }
            Ntemp = 0;//--> Reset statistiche
        } else Ntemp++;
    }
    */
}
