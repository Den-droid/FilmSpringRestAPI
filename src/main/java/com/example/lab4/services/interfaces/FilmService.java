package com.example.lab4.services.interfaces;

import com.example.lab4.models.Film;

import java.util.List;
import java.util.Map;

public interface FilmService {
    List<Film> getAllFilms();

    Film getById(int id);

    List<Film> getPage(int page);

    List<Film> getByName(String name);

    void add(Film film);

    void change(Film film, int id);

    void delete(int id);
}
