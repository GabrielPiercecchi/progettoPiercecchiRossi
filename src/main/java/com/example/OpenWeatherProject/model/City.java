package com.example.OpenWeatherProject.model;

/**
 * Questa classe contiene le variabili e i metodi necessari a definire e a richiamare una città
 */
public class City {

    /**
     * @param name variabile String che serve a contenere il nome di una città
     * @param Id variabile int che serve a identificare in maniera univoca ogni città
     */
    private String Name;
    private int Id;

    /**
     * Questo metodo serve per restituire il nome della città appena salvata
     *
     * @return restituisce il nome della città appena salvata
     */
    public String getName() {
        return Name;
    }

    /**
     * Questo metodo serve salvare il nome della città appena inserita tramite terminale o PostMan
     *
     * @param name variabile String che serve a contenere il nome di una città
     */
    public void setName(String name) {
        this.Name = name;
    }

    /**
     * Questo metodo serve per restituire l'Id della città appena salvata
     *
     * @return restituisce l'Id della città appena salvata
     */
    public int getId() {
        return Id;
    }

    /**
     * Questo metodo serve salvare l'Id della città
     *
     * @param id variabile int che serve a identificare in maniera univoca ogni città
     */
    public void setId(Integer id) {
        Id = id;
    }


}
