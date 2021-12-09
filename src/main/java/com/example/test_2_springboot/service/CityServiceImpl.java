package com.example.test_2_springboot.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CityServiceImpl implements CityService{

    private static Map<Integer, City> cityRepo = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    public CityServiceImpl(){
       //loading data
       City rome = new City();
       rome.setId((int)counter.incrementAndGet());
       rome.setName("Rome");
       cityRepo.put(rome.getId(), rome);

       City milan = new City();
       milan.setId((int)counter.incrementAndGet());
       milan.setName("Milan");
       cityRepo.put(milan.getId(), milan);
   }

    @Override
    public void createCity(City city) {
        if(cityRepo.containsKey(city.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Existing id...");
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
}
