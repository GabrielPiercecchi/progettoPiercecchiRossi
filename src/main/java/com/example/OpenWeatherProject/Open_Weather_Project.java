package com.example.OpenWeatherProject;

import com.example.OpenWeatherProject.menu.Menu;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

/**
 * This class represents the start of the assigned project, and therefore contains the "main" method.
 *
 * @author Piercecchi Gabriel
 * @author Rossi Alan
 *
 * @implNote once the program is finished, format the Json file "FileCities.json".
 */
@SpringBootApplication
public class Open_Weather_Project {

    /**
     * The "main" method is for starting the program.
     */
    public static void main(String[] args) {
        SpringApplication.run(Open_Weather_Project.class, args);
        Menu menu = new Menu();
        menu.menu();
    }
}