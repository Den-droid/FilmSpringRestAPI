package com.example.lab4.repositories.interfaces;

import com.example.lab4.models.Film;

import java.util.List;

public interface FilmRepository {
    List<Film> getAll();

    List<Film> getPage(int elementsPerPage, int page);

    List<Film> getByName(String name);

    Film getById(int id);

    void add(Film film);

    void change(Film film, int id);

    void delete(int id);
}
