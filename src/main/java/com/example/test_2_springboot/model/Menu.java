package com.example.test_2_springboot.model;


import com.example.test_2_springboot.service.CityService;
import com.example.test_2_springboot.service.CityServiceImpl;

import java.util.Scanner;

public class Menu {

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        City city = new City();
        String city1Before;
        String city2Before;
        String city1After;
        String city2After;
        String cont;
        boolean cycle = false;

        //MENU
        while (!cycle) {
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
                    "Let's begin!!\n");

            System.out.println("--> Please insert first city:");
            city1Before = scanner.nextLine();
            System.out.println("--> Please insert second city:");
            city2Before = scanner.nextLine();

            //--> Sostituisco gli spazi con "%20 per poter inserire citta con più "nomi"
            city1After = city1Before.trim().replaceAll(" ", "%20");
            city2After = city2Before.trim().replaceAll(" ", "%20");

            //--> Richiamo metodo inputCity (cerca le città inseirite)
            CityService cityService = new CityServiceImpl();
            cityService.inputCity(city1After, city2After);

            System.out.println();
            System.out.println("--> Do you want to continue? Y/N");
            System.out.println("--> Any other command will terminate the program");
            cont = scanner.nextLine();
            switch (cont) {
                case "Y":
                case "y":
                    break;
                case "N":
                case "n":
                    cycle = true;
                    System.out.println("--> Goodbye ;-)");
                    break;
                default:
                    System.out.println("ERROR\n" +
                            "--> Wrong command\n" +
                            "--> Goodbye ;-)");
                    cycle = true;
            }
        }
    }
}
