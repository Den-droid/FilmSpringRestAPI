package com.example.lab4.repositories.implementation;

import com.example.lab4.models.Film;
import com.example.lab4.repositories.interfaces.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DbInit {
    @Autowired
    private FilmRepository filmRepository;

    @PostConstruct
    private void setDB(){
        setFilms();
    }
    private void setFilms() {
        List<String> actors = new ArrayList<>();
        actors.add("New actor");
        actors.add("New actor2");
        actors.add("New actor3");
        Film film = new Film(1, "Filmname", LocalDate.of(2003, 10, 21), actors,
                LocalTime.of(2, 5, 56), "Description of film",
                "Director of film");
        List<String> actors2 = new ArrayList<>(actors);
        Film film2 = new Film(2, "New Filmname", LocalDate.of(2010, 9, 14), actors2,
                LocalTime.of(2, 10, 45), "Description of film",
                "Director of film");
        filmRepository.add(film);
        filmRepository.add(film2);
    }
}