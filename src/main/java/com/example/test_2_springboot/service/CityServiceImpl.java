package com.example.test_2_springboot.service;

import com.example.test_2_springboot.model.City;
import com.example.test_2_springboot.utilities.ParseJSONDocument;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Questa classe implementa i metodo definiti nell'interfaccia "CityService" associata
 */
@Service
public class CityServiceImpl implements CityService {


    private static Map<Integer, City> cityRepo = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();
    //private static HttpURLConnection connection;


    /**
     * Questo metodo serve a creare di default due città
     */
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

    /**
     * @param city variabile ti tipo City contenente di conseguenza al suo interno le variabili
     *             definite nella class City
     */
    @Override
    public void createCity(City city) {
        if (cityRepo.containsKey(city.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Existing id...");
        }
        cityRepo.put(city.getId(), city);
    }

    /**
     * @param Id   variabile int che serve a identificare univocamente una città
     * @param city variabile String che contiene il nome di una città
     */
    @Override
    public void updateCity(Integer Id, City city) {
        cityRepo.remove(Id);
        city.setId(Id);
        cityRepo.put(Id, city);
    }

    /**
     * @param Id variabile int che serve per identificare univocamente una città
     */
    @Override
    public void deleteCity(Integer Id) {
        cityRepo.remove(Id);
    }

    /**
     * @return restituisce tutte le città salvate fino a quel momento
     */
    @Override
    public Collection<City> getCities() {
        return cityRepo.values();
    }

    /**
     * @param city1 variabile String che contiene il nome della prima città
     * @param city2 variabile String che contiene il nome della prima città
     */
    @Override
    public void inputCity(String city1, String city2) {

        //City city = new City();
        City cityI = new City();
        City cityII = new City();
        String city1After;
        String city2After;

        //--> Sostituisco gli spazi con "%20 per poter inserire citta con più "nomi"
        city1After = city1.trim().replaceAll(" ", "%20");
        city2After = city2.trim().replaceAll(" ", "%20");

        //--> Set city1
        cityI.setId((int) counter.incrementAndGet());
        cityI.setName(city1);
        cityRepo.put(cityI.getId(), cityI);
        //--> Set city2
        cityII.setId((int) counter.incrementAndGet());
        cityII.setName(city2);
        cityRepo.put(cityII.getId(), cityII);

        // Method 2: java.net.Http.HttpClient
        //--> Uso questo metodo URI perchè più pulito e diretto rispetto a quello URL
        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request;

            request = HttpRequest.newBuilder().uri(URI.create("https://api.openweathermap.org/data/2.5/weather?q=" + city1After + "&appid=" + "14bbc528b3c2df06e94336bd503ddc1a")).build();
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    //.thenAccept(System.out::println) --> PRINTLN FILE JSON
                    .thenApply(ParseJSONDocument::parse)
                    .join();

            request = HttpRequest.newBuilder().uri(URI.create("https://api.openweathermap.org/data/2.5/weather?q=" + city2After + "&appid=" + "14bbc528b3c2df06e94336bd503ddc1a")).build();
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(ParseJSONDocument::parse)
                    .join();
        } catch (Exception e) {
            System.out.println("ERROR in the URI request");
        }

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
    }
}
