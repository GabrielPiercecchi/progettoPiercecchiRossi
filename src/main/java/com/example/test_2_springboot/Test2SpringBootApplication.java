package com.example.test_2_springboot;

import com.example.test_2_springboot.model.City;
import com.example.test_2_springboot.model.Menu;
import com.example.test_2_springboot.service.CityService;
import com.example.test_2_springboot.service.CityServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Questa classe rappresenta l'inizio del programma assegnato
 *
 * @author Piercecchi Gabriel
 * @author Rossi Alan
 */
@SpringBootApplication
public class Test2SpringBootApplication {

    /**
     * Questo metodo serve per avviare il programma
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Test2SpringBootApplication.class, args);
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
