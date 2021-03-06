package com.example.OpenWeatherProject.service;

import com.example.OpenWeatherProject.model.City;
import java.util.Collection;

/**
 * This interface is used to contain all the methods called up by the user, via Postman and/or through the terminal,
 * that interact with the cities saved in the program.
 */
public interface CityService {

    /**
     * This method is for create a city.
     *
     * @param city City-type variable containing consequently the attributes defined in the "City" class.
     */
    void createCity(City city);

    /**
     * This method is for update the name of a city.
     *
     * @param Id   int variable used to uniquely identify a city.
     * @param city City-type variable containing consequently the attributes defined in the "City" class.
     */
    void updateCity(Integer Id, City city);

    /**
     * This method is for delete a city saved in the program.
     *
     * @param Id int variable used to uniquely identify a city.
     */
    void deleteCity(Integer Id);

    /**
     * This method is used to search the meteorological data of two cities through URI requests to the
     * current API of "OpenWeather".
     *
     * @param city1 String variable that contains the name of the first city.
     * @param city2 String variable that contains the name of the second city.
     */
    void inputCity(String city1, String city2);

    /**
     * This method is used to print all cities saved up to the time of the call.
     *
     * @return returns all cities saved up to the time of the call.
     */
    Collection<City> getCities();
}