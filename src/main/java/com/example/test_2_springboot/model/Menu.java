package com.example.test_2_springboot.model;


import com.example.test_2_springboot.service.CityService;
import com.example.test_2_springboot.service.CityServiceImpl;

import java.util.Scanner;

public class Menu {

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        City city = new City();
        String city1;
        String city2;
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
            city1 = scanner.nextLine();
            System.out.println("--> Please insert second city:");
            city2 = scanner.nextLine();

            CityService cityService = new CityServiceImpl();
            cityService.inputCity(city1,city2);

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
