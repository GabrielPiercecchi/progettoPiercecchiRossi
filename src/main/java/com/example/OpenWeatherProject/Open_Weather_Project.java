package com.example.OpenWeatherProject;

import com.example.OpenWeatherProject.menu.Menu;
import com.example.OpenWeatherProject.service.CityService;
import com.example.OpenWeatherProject.service.CityServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Questa classe rappresenta l'inizio del programma assegnato
 *
 * @implNote terminato il programma formattare il file "fileCities.json"
 *
 * @author Piercecchi Gabriel
 * @author Rossi Alan
 */
@SpringBootApplication
public class Open_Weather_Project {

    /**
     * Questo metodo serve per avviare il programma
     */
    public static void main(String[] args) {
        SpringApplication.run(Open_Weather_Project.class, args);
        CityService cityService = new CityServiceImpl();
        Menu menu = new Menu();
        menu.menu();

        /*
         Maven dependency for JSON-simple:
            <dependency>
                <groupId>com.googlecode.json-simple</groupId>
                <artifactId>json-simple</artifactId>
                <version>1.1.1</version>
            </dependency>
         */

    }
}
