package com.example.test_2_springboot.service;

import com.example.test_2_springboot.model.City;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Collection;

public interface CityService {

    public abstract void createCity(City city);

    public abstract void updateCity(Integer Id, City city);

    public abstract void deleteCity(Integer Id);

    public abstract void inputCity(String city1, String city2);

    public abstract Collection<City> getCities();
}

