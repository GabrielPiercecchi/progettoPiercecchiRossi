package com.example.test_2_springboot.service;

import java.util.Collection;

public interface CityService {

    public abstract void createCity(City city);
    public abstract void updateCity(Integer Id, City city);
    public abstract void deleteCity(Integer Id);
    public abstract Collection<City> getCities();
}
