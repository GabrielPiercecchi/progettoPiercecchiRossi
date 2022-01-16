package com.example.OpenWeatherProject.menu;


import com.example.OpenWeatherProject.filters.ControlFiltersImpl;
import com.example.OpenWeatherProject.service.CityService;
import com.example.OpenWeatherProject.service.CityServiceImpl;

import java.util.Scanner;

/**
 * Questa classe contiene il menu con cui l'utente dovrà interagire per utilizzare il programma
 */
public class Menu {

    /**
     * Questo metodo rappresenta il MENU del programma assegnato
     */
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        ControlFiltersImpl controlFilters = new ControlFiltersImpl();

        //City city = new City();
        String city1Before;
        String city2Before;
        String cont;
        boolean cycle = false;

        //MENU
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

            System.out.println("--> Please insert first city:");
            city1Before = scanner.nextLine();
            System.out.println("--> Please insert second city:");
            city2Before = scanner.nextLine();

            //--> Richiamo metodo inputCity (cerca le città inserite)
            CityService cityService = new CityServiceImpl();
            cityService.inputCity(city1Before, city2Before);

            System.out.println();

            //--> Questo ciclo do-while permette d'inserire più coppie di città
            boolean switchC = false;
            do {
                System.out.println("--> Do you want to continue? Y/N");
                cont = scanner.nextLine();
                switch (cont) {
                    case "Y":
                    case "y":
                        //--> Questo switch annidato permette d'inserire una data da usare come "filter"
                        System.out.println("--> Do you want to filter the cities already called? (Y/N)");
                        String wantDate = scanner.nextLine();
                        switch (wantDate) {
                            case "Y":
                            case "y":
                                try {
                                    System.out.println("--> Please insert two dates:");
                                    System.out.println("(Date format: dd-MM-yyyy HH:mm:ss)");
                                    System.out.println("--> First one:");
                                    String strDate1 = scanner.nextLine();
                                    System.out.println("--> Second one:");
                                    String strDate2 = scanner.nextLine();
                                    //--> Richiamo metodo checkData della classe controlFilters
                                    controlFilters.checkData(strDate1, strDate2);
                                } catch (Exception e) {
                                    System.out.println("--> ERROR");
                                    System.out.println("--> Date format not acceptable");
                                }
                                break;
                            case "N":
                            case "n":
                                switchC = true;
                                break;
                            default:
                                System.out.println("ERROR\n" +
                                        "--> Wrong command\n" +
                                        "--> Please use the right ones ;-)");
                        }
                        break;
                    case "N":
                    case "n":
                        cycle = true;
                        switchC = true;
                        System.out.println("--> Goodbye ;-)");
                        break;
                    default:
                        System.out.println("ERROR\n" +
                                "--> Wrong command\n" +
                                "--> Please use the right ones ;-)");
                }
            } while (!switchC);
        } while (!cycle);
    }
}
