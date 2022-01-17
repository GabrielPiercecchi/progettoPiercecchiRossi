package com.example.OpenWeatherProject;

import com.example.OpenWeatherProject.menu.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Questa classe rappresenta l'inizio del programma assegnato
 *
 * @author Piercecchi Gabriel
 * @author Rossi Alan
 * @implNote terminato il programma formattare il file "fileCities.json"
 */
@SpringBootApplication
public class Open_Weather_Project {

    /**
     * Questo metodo serve per avviare il programma
     */
    public static void main(String[] args) {
        SpringApplication.run(Open_Weather_Project.class, args);
        Menu menu = new Menu();
        menu.menu();
    }
}
