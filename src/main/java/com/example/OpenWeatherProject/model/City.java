package com.example.OpenWeatherProject.model;

/**
 * This class contains the variables and methods needed to define and retrieve a city
 */
public class City {

    private String Name;
    private int Id;

    /**
     * This method is used to return the name of the city just saved
     *
     * @return returns the name of the city just saved
     */
    public String getName() {
        return Name;
    }

    /**
     * This method is used to save the name of the city just entered via the terminal or Postman
     *
     * @param name String variable that is used to hold the name of a city
     */
    public void setName(String name) {
        this.Name = name;
    }

    /**
     * This method is used to return the ID of the city just saved
     *
     * @return returns the Id of the city just saved
     */
    public int getId() {
        return Id;
    }

    /**
     * This method is for saving the city ID
     *
     * @param id int variable that serves to uniquely identify each city
     */
    public void setId(Integer id) {
        Id = id;
    }
}