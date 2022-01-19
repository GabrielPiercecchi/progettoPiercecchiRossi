package com.example.OpenWeatherProject.model;

/**
 * This class contains the variables and methods needed to define and retrieve a city.
 */
public class City {

    private String Name;
    private int Id;

    /**
     * This method is used to return the name of a city.
     *
     * @return returns the name of a city.
     */
    public String getName() {
        return Name;
    }

    /**
     * This method is used to set the name of a city.
     *
     * @param name String variable that is used to hold the name of a city.
     */
    public void setName(String name) {
        this.Name = name;
    }

    /**
     * This method is used to return the ID of a city.
     *
     * @return returns the ID of a city.
     */
    public int getId() {
        return Id;
    }

    /**
     * This method is used to set the city ID.
     *
     * @param id int variable that serves to uniquely identify each city.
     */
    public void setId(Integer id) {
        Id = id;
    }
}