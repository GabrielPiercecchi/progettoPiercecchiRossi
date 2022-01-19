package com.example.OpenWeatherProject.controller;

import com.example.OpenWeatherProject.model.City;
import com.example.OpenWeatherProject.service.CityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



/**
 * This class contains all the methods used to "communicate" with Postman
 */
@RestController
public class CityController {

    @Autowired
    CityService cityService;

    /**
     * This method is used to call the method which returns all the cities saved within the program
     * via PostMan
     *
     * @return returns all saved cities
     */
    @GetMapping(value = "/cities")
    public ResponseEntity<Object>
    getCity() {
        return new ResponseEntity<>(cityService.getCities(), HttpStatus.OK);
    }

    /**
     * This method is used to call the method that updates, through the {id}, the name of the cities already saved
     * via Postman
     *
     * @param id   int variable that uniquely represents each city
     * @param city String variable that represents the name of the city
     * @return returns a string if the city update is successful
     */
    @PutMapping(value = "/cities/{id}")
    public ResponseEntity<Object>
    updateCity(@PathVariable("id") int id, @RequestBody City city) {
        cityService.updateCity(id, city);
        return new ResponseEntity<>("City is updated successfully", HttpStatus.OK);
    }

    /**
     * This method is used to recall the method that eliminates, using the {id}, a saved city
     * via PostMan
     *
     * @param id int variable that uniquely represents each city
     * @return returns a string if the deletion of the city is successful
     */
    @DeleteMapping(value = "/cities/{id}")
    public ResponseEntity<Object>
    delete(@PathVariable("id") Integer id) {
        cityService.deleteCity(id);
        return new ResponseEntity<>("City is deleted successfully", HttpStatus.OK);
    }

    /**
     * This method is used to call the method which adds new cities to the program via Postman
     *
     * @param city String variable that represents the name of the city
     * @return returns a string if the creation of the city is successful
     */
    @PostMapping(value = "/cities")
    public ResponseEntity<Object>
    createCity(@RequestBody City city) {
        cityService.createCity((city));
        return new ResponseEntity<>("City is created successfully", HttpStatus.OK);
    }

    /**
     * This method is used to call the method that causes the program to receive the data in
     * Json of two cities via Postman
     *
     * @param cities String variable that is used to contain the names of the two cities taken into consideration
     * @return returns a string if the city search is successful
     */
    @PostMapping(value = "/cities/names")
    public ResponseEntity<Object>
    citiesName(@RequestBody String cities) {
        JSONObject obj = new JSONObject(cities);
        String city1 = (String) obj.get("city1");
        String city2 = (String) obj.get("city2");
        cityService.inputCity(city1, city2);
        return new ResponseEntity<>("Cities accepted, check the terminal!!", HttpStatus.OK);
    }

    /**
     * This method is used to return all the data of the cities saved in the Json file "FileCities.json"
     *
     * @return returns all data saved in the file "FileCities.json"
     */
    @GetMapping(value = "/cities/metadata")
    public @ResponseBody
    Object getCityData() {
        File file = new File("FileCities.json");
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(file.getAbsoluteFile(), Object.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}