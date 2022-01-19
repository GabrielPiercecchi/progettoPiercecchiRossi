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
 * This class implements the methods defined in the associated "CityService" interface
 */
@Service
public class CityServiceImpl implements CityService {

    private static Map<Integer, City> cityRepo = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    /**
     * This method is used to create two cities by default
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
     * @param city City-type variable containing consequently the attributes defined in the "City" class.
     */
    @Override
    public void createCity(City city) {
        if (cityRepo.containsKey(city.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Existing id...");
        }
        cityRepo.put(city.getId(), city);
    }


    /**
     * @param Id   int variable used to uniquely identify a city.
     * @param city City-type variable containing consequently the attributes defined in the "City" class.
     */
    @Override
    public void updateCity(Integer Id, City city) {
        cityRepo.remove(Id);
        city.setId(Id);
        cityRepo.put(Id, city);
    }

    /**
     * @param Id int variable used to uniquely identify a city.
     */
    @Override
    public void deleteCity(Integer Id) {
        cityRepo.remove(Id);
    }

    /**
     * @return returns all cities saved up to the time of the call.
     */
    @Override
    public Collection<City> getCities() {
        return cityRepo.values();
    }

    /**
     * @param city1 String variable that contains the name of the first city.
     * @param city2 String variable that contains the name of the second city.
     */
    @Override
    public void inputCity(String city1, String city2) {

        //City city = new City();
        City cityI = new City();
        City cityII = new City();
        String city1After;
        String city2After;

        //--> Sostituisco gli spazi con "%20 per poter inserire città con più "nomi"
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
        //--> Uso questo metodo URI perché più pulito e diretto rispetto a quello URL
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
