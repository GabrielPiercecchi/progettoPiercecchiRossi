package com.example.OpenWeatherProject.filters;

import com.example.OpenWeatherProject.model.JSONStructure;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class contains the methods necessary to filter the data according to a time range chosen by the user,
 * and print them on the terminal.
 */
public class DateTimeFiltersImpl implements DateTimeFilters {

    public final ArrayList<JSONStructure> dateTimeFiltered = new ArrayList<>();

    /**
     * This method filters data present on the JSONStructure-type ArrayList "cityFiltered", afterwards passed
     * as a parameter to the method, in the time range defined by the two String variables (subsequently converted
     * to Date variables) startStringDateTime and endStringDateTime.
     *
     * @param jsonStructure JSONStructure-type ArrayList containing all the attributes and methods of the
     *                      "JSONStructure" model-class.
     * @param startStringDateTime String variable that contains the first date.
     * @param endStringDateTime String variable that contains the second date.
     */
    @Override
    public void dateTimeFilter(ArrayList<JSONStructure> jsonStructure, String startStringDateTime,
                               String endStringDateTime) {
        try {

            SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yy HH:mm:ss");

            Date startDateTime = parser.parse(startStringDateTime);
            Date endDateTime = parser.parse(endStringDateTime);

            boolean controller = endDateTime.after(startDateTime);

            if (!controller) {

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
            System.out.println("ERROR");
            System.out.println("--> File not parsed correctly");
            System.out.println("--> Wrong dates entered");
            System.out.println();
        }
        jsonStructure.clear();
    }

    /**
     * This method prints filtered data to the terminal.
     */
    @Override
    public void printDateTimeFiltered() {

        if (dateTimeFiltered.size() == 0) {
            System.out.println("--> There are no cities call collected");
            System.out.println();
        } else {
            for (int i = 0; i < dateTimeFiltered.size(); i++) {
                if (i==0){
                    System.out.println("--> Data collected from " + dateTimeFiltered.get(i).getTime() + " to " +
                            dateTimeFiltered.get(dateTimeFiltered.size()-1).getTime() + " are:");
                    System.out.println();
                }
                System.out.println(dateTimeFiltered.get(i).toString(i));
            }
        }
    }
}