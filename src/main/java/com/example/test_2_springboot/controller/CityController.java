package com.example.test_2_springboot.controller;

import com.example.test_2_springboot.service.City;
import com.example.test_2_springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {

    @Autowired
    CityService cityService;

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public ResponseEntity<Object>
        getCity(){
            return new ResponseEntity<>(cityService.getCities(), HttpStatus.OK);
    }

    @RequestMapping(value = "/cities/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
        updateCity(@PathVariable("id") int id, @RequestBody City city){
            cityService.updateCity(id,city);
            return new ResponseEntity<>("City is updated successfully",HttpStatus.OK);
    }

    @RequestMapping(value = "/cities/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object>
        delete(@PathVariable("id") Integer id){
            cityService.deleteCity(id);
            return new ResponseEntity<>("City is deleted successfully",HttpStatus.OK);
    }

    @RequestMapping(value = "/cities", method = RequestMethod.POST)
    public ResponseEntity<Object>
        createCity(@RequestBody City city){
            cityService.createCity((city));
            return new ResponseEntity<>("City is created successfully", HttpStatus.OK);
    }


}
