package com.example.test_2_springboot.service;

import com.example.test_2_springboot.model.City;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Collection;

/**
 * Questa interfaccia serve a contenere tutti i metodi richiamati dell'utente, da PostMan e/o da terminale,
 * che interagiscono le città salvate nel programma
 */
public interface CityService {

    /**
     * Questo metodo serve per creare una città
     *
     * @param city variabile ti tipo City contenente di conseguenza al suo interno le variabili definite nella class City
     */
    public abstract void createCity(City city);

    /**
     * Questo metodo serve per aggiornare il nome di una città
     *
     * @param Id   variabile int che serve a identificare univocamente una città
     * @param city variabile String che contiene il nome di una città
     */
    public abstract void updateCity(Integer Id, City city);

    /**
     * Questo metodo serve per eliminare una città salvata nel programma
     *
     * @param Id variabile int che serve per identificare univocamente una città
     */
    public abstract void deleteCity(Integer Id);

    /**
     * Questo metodo serve per ricercare i dati meteorologici di due città tramite delle richieste di
     * tipo URI all'API current di "Open-weather"
     *
     * @param city1 variabile String che contiene il nome della prima città
     * @param city2 variabile String che contiene il nome della prima città
     */
    public abstract void inputCity(String city1, String city2);

    /**
     * Questo metodo viene utilizzato per stampare tutte le città salvate fino a quel momento
     *
     * @return restituisce tutte le città salvate fino a quel momento
     */
    public abstract Collection<City> getCities();
}

