package com.example.test_2_springboot.model;


import com.example.test_2_springboot.service.CityService;
import com.example.test_2_springboot.service.CityServiceImpl;

import java.util.Scanner;

/**
 * Questa classe contiene il menu con cui l'utente dovrà interagire per utilizzare il programma
 */
public class Menu {

    /**
     * Questo metodo rappresenta il menu del programma assegnato
     */
    public void menu() {
        Scanner scanner = new Scanner(System.in);

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

            //--> Richiamo metodo inputCity (cerca le città inseirite)
            CityService cityService = new CityServiceImpl();
            cityService.inputCity(city1Before, city2Before);

            System.out.println();

            boolean switchC = false;
            do {
                System.out.println("--> Do you want to continue? Y/N");
                cont = scanner.nextLine();
                switch (cont) {
                    case "Y":
                    case "y":
                        switchC = true;
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
