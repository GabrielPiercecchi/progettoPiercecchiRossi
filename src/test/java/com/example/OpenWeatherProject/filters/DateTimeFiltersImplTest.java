package com.example.OpenWeatherProject.filters;

import com.example.OpenWeatherProject.model.JSONStructure;
import com.example.OpenWeatherProject.utilities.JSONFileManager;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeFiltersImplTest {

    DateTimeFiltersImpl dateTimeFiltersImpl = new DateTimeFiltersImpl();
    CityFilters cityFilters = new CityFilters();

    @Test
    void dateTimeFilter() throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yy HH:mm:ss");

        Date dateTime = parser.parse("12-02-2021 11:00:00");
        ArrayList<JSONStructure> dateTimeFilters = new ArrayList<>();
        dateTimeFilters.get(0).setTime(dateTime);
        dateTimeFilters.get(0).setName("Rome");
        dateTimeFilters.get(0).setTemp(8.0);
        dateTimeFilters.get(0).setFeelsLike(12.0);
        dateTimeFilters.get(0).setTempMin(-20.0);
        dateTimeFilters.get(0).setTempMax(30.0);

        JSONFileManager.jsonFileManager();
        cityFilters.cityFilter(dateTimeFilters, "All");

        dateTimeFiltersImpl.dateTimeFilter(dateTimeFilters, "12-02-2022 12:00:00",
                "12-02-2023 12:00:00");
        dateTimeFiltersImpl.printDateTimeFiltered();
    }

    @Test
    void printDateTimeFiltered() {
    }
}