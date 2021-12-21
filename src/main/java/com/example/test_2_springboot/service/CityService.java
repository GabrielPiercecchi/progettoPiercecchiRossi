package com.example.test_2_springboot.service;

import com.example.test_2_springboot.model.City;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Collection;

public interface CityService {

    public abstract void createCity(City city);
    public abstract void updateCity(Integer Id, City city);
    public abstract void deleteCity(Integer Id);
    //--> Contiene menù e inserimento delle due città
    //--> Possubile separare le due cose
    public abstract void inputCity();
    public abstract Collection<City> getCities();
}
