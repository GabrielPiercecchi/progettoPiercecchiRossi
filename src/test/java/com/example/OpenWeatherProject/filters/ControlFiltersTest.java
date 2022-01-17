package com.example.OpenWeatherProject.filters;

import com.example.OpenWeatherProject.service.CityService;
import com.example.OpenWeatherProject.service.CityServiceImpl;
import org.junit.jupiter.api.Test;

/**
 * Test Class per ControlFilters
 */
class ControlFiltersTest {

    ControlFilters controlFilters = new ControlFiltersImpl();
    CityService cityService = new CityServiceImpl();

    private String date1;
    private String date2;

    /**
     * Test che controlla se il metodo checkData funziona correttamente
     */
    @Test
    void checkData() {
        cityService.inputCity("ancona", "porto recanati");
        cityService.inputCity("rome", "bolzano");
        cityService.inputCity("jkbkkk", "riccione");
        date1 = "12-09-2022 10:00:00";
        date2 = "12-09-2020 10:00:00";
        controlFilters.checkData(date1, date2);
        System.out.println();
        System.out.println("--> inputCity and checkData run correctly");
    }
}