package com.example.test_2_springboot.model;

public class City {

    private String name;
    private int Id;
    //API-KEY messa qui per comodità
    private String ApiKey1 = "14bbc528b3c2df06e94336bd503ddc1a";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getApiKey1(){
        return ApiKey1;
    }

}
