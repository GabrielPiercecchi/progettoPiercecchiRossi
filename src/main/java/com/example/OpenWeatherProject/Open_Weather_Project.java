package com.example.OpenWeatherProject;

import com.example.OpenWeatherProject.menu.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class represents the start of the assigned project
 *
 * @author Piercecchi Gabriel
 * @author Rossi Alan
 * @implNote once the program is finished, format the file "fileCities.json"
 */
@SpringBootApplication
public class Open_Weather_Project {

    /**
     * This method is for starting the program
     */
    public static void main(String[] args) {
        SpringApplication.run(Open_Weather_Project.class, args);
        Menu menu = new Menu();
        menu.menu();
    }
}
