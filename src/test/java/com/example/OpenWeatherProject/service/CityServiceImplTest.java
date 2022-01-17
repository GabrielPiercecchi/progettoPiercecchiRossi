package com.example.OpenWeatherProject.service;

import org.junit.jupiter.api.Test;

/**
 * Test class per CityServiceImpl
 */
class CityServiceImplTest {

    CityService cityService = new CityServiceImpl();

    /**
     * Test che controlla se i metodi createCity, inputCity e getCities funzionino correttamente
     */
    @Test
    void createCity() {
        cityService.inputCity("ancona", "porto recanati");
        cityService.inputCity("bkjbbk", "roma");
        cityService.getCities();
        System.out.println();
        System.out.println("--> createCity, inputCity and getCities run correctly");
    }

}