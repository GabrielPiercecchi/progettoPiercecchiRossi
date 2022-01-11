package com.example.test_2_springboot.controller;

import com.example.test_2_springboot.model.City;
import com.example.test_2_springboot.model.Menu;
import com.example.test_2_springboot.service.CityService;
import com.example.test_2_springboot.service.CityServiceImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Questa classe contiene tutti i metodi che servono a comunicare con PostMan
 */
@RestController
public class CityController {

    @Autowired
    CityService cityService;

    /**
     * Questo metodo serve a richiamare il metodo che restituisce tutte le città salvate all'interno del programma
     * tramite PostMan
     *
     * @return restituisce tutte le città salvate
     */
    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public ResponseEntity<Object>
    getCity() {
        return new ResponseEntity<>(cityService.getCities(), HttpStatus.OK);
    }

    /**
     * Questo metodo serve a richiamare il metodo che aggiorna, tramite l'Id, il nome delle città già salvate
     * tramite PostMan
     *
     * @param id variabile int che rappresenta in modo univoco ogni città
     * @param city variabile String che rappresenta il nome della città
     * @return restituisce, nel caso in cui l'aggiornamento della città sia riuscito, una stringa
     */
    @RequestMapping(value = "/cities/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
    updateCity(@PathVariable("id") int id, @RequestBody City city) {
        cityService.updateCity(id, city);
        return new ResponseEntity<>("City is updated successfully", HttpStatus.OK);
    }

    /**
     * Questo metodo serve a richiamare il metodo che elimina, sfruttando l'Id, una città salvata
     * tramite PostMan
     *
     * @param id variabile int che rappresenta in modo univoco ogni città
     * @return restituisce, nel caso in cui l'eliminazione della città sia riuscita, una stringa
     */
    @RequestMapping(value = "/cities/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object>
    delete(@PathVariable("id") Integer id) {
        cityService.deleteCity(id);
        return new ResponseEntity<>("City is deleted successfully", HttpStatus.OK);
    }

    /**
     * Questo metodo serve a richiamare il metodo che aggiunge nuove città al programma tramite PostMan
     *
     * @param city variabile String che rappresenta il nome della città
     * @return restituisce, nel caso in cui la creazione della città sia riuscita, una stringa
     */
    @RequestMapping(value = "/cities", method = RequestMethod.POST)
    public ResponseEntity<Object>
    createCity(@RequestBody City city) {
        cityService.createCity((city));
        return new ResponseEntity<>("City is created successfully", HttpStatus.OK);
    }

    /**
     * Questo metodo serve a richiamare il metodo che fa ricevere al programma tramite PostMan i dati in formato
     * Json di due città tramite PostMan
     *
     * @param cities variabile String che serve a contenere i nomi delle due città che si vogliono studiare
     * @return restituisce, nel caso in cui la ricerca delle città sia riuscita, una stringa
     */
    @RequestMapping(value = "/cities/names", method = RequestMethod.POST)
    public ResponseEntity<Object>
    nameCities(@RequestBody String cities) {
        JSONObject obj = new JSONObject(cities);
        String city1 = (String) obj.get("city1");
        String city2 = (String) obj.get("city2");
        cityService.inputCity(city1, city2);
        return new ResponseEntity<>("Cities accepted, check the terminal!!", HttpStatus.OK);
    }
}
