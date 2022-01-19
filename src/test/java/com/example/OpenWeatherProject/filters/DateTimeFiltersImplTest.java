package com.example.OpenWeatherProject.filters;

import com.example.OpenWeatherProject.model.JSONStructure;
import com.example.OpenWeatherProject.utilities.JSONFileManager;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class DateTimeFiltersImplTest {

    DateTimeFiltersImpl dateTimeFiltersImpl = new DateTimeFiltersImpl();
    CityFilters cityFilters = new CityFilters();

    /**
     * Test che controlla se i metodi dell'interfaccia "DateTimeFilters", le classi JSONFileManager e
     * CityFilters funzionino correttamente
     */
    @Test
    void dateTimeFilter() throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yy HH:mm:ss");

        Date dateTime1 = parser.parse("12-02-2021 11:00:00");
        Date dateTime2 = parser.parse("04-01-2020 09:23:00");
        Date dateTime3 = parser.parse("12-02-2023 11:00:00");
        Date dateTime4 = parser.parse("11-04-2020 15:00:00");

        ArrayList<JSONStructure> dateTimeFilters = new ArrayList<>();

        dateTimeFilters.add(new JSONStructure("Ancona", dateTime1, 8.0,4.0,-2.0,
                10.0));
        dateTimeFilters.add(new JSONStructure("Porto recanati", dateTime2, 34.0,12.0,-2.0,
                10.0));
        dateTimeFilters.add(new JSONStructure("Foggia", dateTime3, 0.0,4.0,-21.0,
                11.0));
        dateTimeFilters.add(new JSONStructure("Trento", dateTime4, 33.8,4.0,-21.0,
                112.5));

        JSONFileManager.jsonFileManager();
        cityFilters.cityFilter(dateTimeFilters, "All");

        dateTimeFiltersImpl.dateTimeFilter(dateTimeFilters, "12-02-2021 11:00:00",
                "12-02-2023 11:00:00");
        dateTimeFiltersImpl.printDateTimeFiltered();

        //--> Pulizia ArrayList
        dateTimeFilters.clear();
        cityFilters.cityFiltered.clear();

        //--> Test in successione
        dateTimeFilters.add(new JSONStructure("Porto recanati", dateTime2, 34.0,12.0,-2.0,
                10.0));
        dateTimeFilters.add(new JSONStructure("Foggia", dateTime3, 0.0,4.0,-21.0,
                11.0));
        dateTimeFilters.add(new JSONStructure("Trento", dateTime4, 33.8,4.0,-21.0,
                112.5));

        JSONFileManager.jsonFileManager();
        cityFilters.cityFilter(dateTimeFilters, "All");

        dateTimeFiltersImpl.dateTimeFilter(dateTimeFilters, "12-02-2024 11:00:00",
                "12-02-2023 11:00:00");
        dateTimeFiltersImpl.printDateTimeFiltered();

        //--> Pulizia ArrayList
        dateTimeFilters.clear();
        cityFilters.cityFiltered.clear();
    }

    @Test
    void printDateTimeFiltered() {
    }
}