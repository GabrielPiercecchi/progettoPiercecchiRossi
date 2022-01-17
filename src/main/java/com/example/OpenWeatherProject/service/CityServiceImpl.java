package com.example.OpenWeatherProject.service;

import com.example.OpenWeatherProject.model.City;
import com.example.OpenWeatherProject.utilities.ParseJSONDocument;
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
     *
     * @param Id   variabile di tipo int che serve a identificare univocamente una città
     * @param city variabile di tipo City contenente di conseguenza al suo interno le variabili definite nella class City
     */
    @Override
    public void updateCity(Integer Id, City city) {
        cityRepo.remove(Id);
        city.setId(Id);
        cityRepo.put(Id, city);
    }

    /**
     *
     * @param Id variabile di tipo int che serve per identificare univocamente una città
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
     *
     * @param city1 variabile di tipo String che contiene il nome della prima città
     * @param city2 variabile di tipo String che contiene il nome della prima città
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
    }
}
