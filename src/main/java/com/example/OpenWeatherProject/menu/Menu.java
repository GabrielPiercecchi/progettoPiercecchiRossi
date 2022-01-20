package com.example.OpenWeatherProject.menu;

import com.example.OpenWeatherProject.filters.CityFilters;
import com.example.OpenWeatherProject.filters.DateTimeFiltersImpl;
import com.example.OpenWeatherProject.service.CityService;
import com.example.OpenWeatherProject.service.CityServiceImpl;
import com.example.OpenWeatherProject.utilities.JSONFileManager;
import java.util.Scanner;

/**
 * This class contains the menu (usable through the terminal) which the user will have to interact with
 * to use the program.
 */
public class Menu {

    Scanner scanner = new Scanner(System.in);

    /**
     * this method allows the user to use the services provided by this program, calling the "searchCity"
     * and "filterCity" methods of this same class.
     */
    public void menu() {

        boolean cycle = false;

        do {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("********************************");
            System.out.println("WELCOME TO OUR WEATHER PROGRAM!!");
            System.out.println("********************************");
            System.out.println();
            System.out.println("Description:");
            System.out.println("--------------------------------");
            System.out.println("With this program you can search and see the current temperatures of two different cities\n" +
                    "and compare them!!\n" +
                    "Finally you can see all your history call on the JSON file called 'FileCities.json'." +
                    "Let's begin!!\n");

            boolean control1 = false;
            do {
                System.out.println("--> Which operation do you want to do? <1>/<2>" +
                        "\n--> 1) search the statistics of two cities" +
                        "\n--> 2) filter the statistics already collected (in previous searches)");
                String input = scanner.nextLine();
                switch (input) {
                    case "1":
                        searchCity();
                        control1 = true;
                        break;
                    case "2":
                        filterCity();
                        control1 = true;
                        break;
                    default:
                        System.out.println("ERROR\n" +
                                "--> Wrong command\n" +
                                "--> Please use the right ones ;-)");
                        System.out.println();
                }
            } while (!control1);

            boolean control2 = false;
            do {
                System.out.println("--> Do you want to terminate the program? (Y/N)\n");
                String input = scanner.nextLine();
                switch (input) {
                    case "Y":
                    case "y":
                        cycle = true;
                        control2 = true;
                        System.out.println("--> Goodbye ;-)");
                        break;
                    case "N":
                    case "n":
                        control2 = true;
                        break;
                    default:
                        System.out.println("ERROR\n" +
                                "--> Wrong command\n" +
                                "--> Please use the right ones ;-)");
                        System.out.println();
                }
            } while (!control2);
        } while (!cycle);
    }

    /**
     * This method deals with managing the search for two cities (and the related statistical data), calling
     * the "inputCity" method of the "CityServiceImpl" class (through its instance).
     */
    public void searchCity() {

        boolean cycle = false;

        do {
            System.out.println("--> Please insert first city:");
            String city1Before = scanner.nextLine();
            System.out.println("--> Please insert second city:");
            String city2Before = scanner.nextLine();
            System.out.println();

            // call "inputCity" method (search entered cities)
            CityService cityService = new CityServiceImpl();
            cityService.inputCity(city1Before, city2Before);

            System.out.println();

            boolean control1 = false;
            do {
                System.out.println("--> Do you want to keep searching? (Y/N)");
                String input = scanner.nextLine();
                switch (input) {
                    case "Y":
                    case "y":
                        control1 = true;
                        break;
                    case "N":
                    case "n":
                        control1 = true;
                        cycle = true;
                        break;
                    default:
                        System.out.println("ERROR\n" +
                                "--> Wrong command\n" +
                                "--> Please use the right ones ;-)");
                        System.out.println();
                }
            } while (!control1);
        } while (!cycle);
    }

    /**
     * This method takes care of managing the filtering of the data, appropriately calling the methods of
     * the "filters" package classes (through their instances).
     */
    public void filterCity() {

        CityFilters cityFilters = new CityFilters();
        DateTimeFiltersImpl dateTimeFiltersImpl = new DateTimeFiltersImpl();

        boolean cycle = false;

        do {

            try {

                System.out.println("--> Do you want to filter a single city data " +
                        "or all data? <CityName>/<all>");
                System.out.println("(All the foreign cities and the most important\n" +
                        "italian cities must be entered strictly in english )");
                System.out.println("E.g. rome, turin, milan, florence,...");
                String strFilter = scanner.nextLine();
                // call the method that deserializes data contained in the Json file
                // and data is copied to the "jsonStructure" ArrayList
                JSONFileManager.jsonFileManager();
                // data is filtered according to the chosen city
                cityFilters.cityFilter(JSONFileManager.jsonStructure, strFilter);

                System.out.println("--> Please now insert two dates:");
                System.out.println("(Date format: dd-MM-yyyy HH:mm:ss)");
                System.out.println("--> First one:");
                String strDate1 = scanner.nextLine();
                System.out.println("--> Second one:");
                String strDate2 = scanner.nextLine();

                // filter the data further using the two dates just entered
                dateTimeFiltersImpl.dateTimeFilter(cityFilters.cityFiltered, strDate1, strDate2);
                dateTimeFiltersImpl.printDateTimeFiltered();

                // delete data from ArrayLists
                cityFilters.cityFiltered.clear();
                dateTimeFiltersImpl.dateTimeFiltered.clear();
            } catch (Exception e) {
                System.out.println("--> ERROR");
                System.out.println("--> Date format not acceptable");
            }

            boolean control1 = false;
            do {
                System.out.println("--> Do you want to continue filtering? (Y/N)");
                String input = scanner.nextLine();
                switch (input) {
                    case "Y":
                    case "y":
                        control1 = true;
                        break;
                    case "N":
                    case "n":
                        control1 = true;
                        cycle = true;
                        break;
                    default:
                        System.out.println("ERROR\n" +
                                "--> Wrong command\n" +
                                "--> Please use the right ones ;-)");
                        System.out.println();
                }
            } while (!control1);
        } while (!cycle);
    }
}