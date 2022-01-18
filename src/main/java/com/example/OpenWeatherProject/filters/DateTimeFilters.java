package com.example.OpenWeatherProject.filters;

import com.example.OpenWeatherProject.model.JSONStructure;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DateTimeFilters {

    protected ArrayList<JSONStructure> dateTimeFiltered = new ArrayList<>();

    public void dateTimeFilter(ArrayList<JSONStructure> jsonStructure, String startStringDateTime, String endStringDateTime) {

        try {

            SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yy HH:mm:ss");

            Date startDateTime = parser.parse(startStringDateTime);
            Date endDateTime = parser.parse(endStringDateTime);

            boolean controller =endDateTime.after(startDateTime);

            if(!controller) {

                Date append;
                append = startDateTime;
                startDateTime = endDateTime;
                endDateTime = append;
            }

            for (JSONStructure elem : jsonStructure) {

                if (startDateTime.compareTo(elem.getTime()) <= 0 && endDateTime.compareTo(elem.getTime()) >= 0) {
                    dateTimeFiltered.add(elem);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void printDateTimeFiltered() {
        for(int i = 0; i < dateTimeFiltered.size(); i++) {
            System.out.println(dateTimeFiltered.get(i).toString());
        }
    }
}
