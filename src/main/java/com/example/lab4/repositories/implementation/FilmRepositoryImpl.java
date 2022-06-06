package com.example.lab4.repositories.implementation;

import com.example.lab4.models.Film;
import com.example.lab4.repositories.interfaces.FilmRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Repository
public class FilmRepositoryImpl implements FilmRepository {
    private final List<Film> films = new ArrayList<>();

    private FilmRepositoryImpl() {

    }

    @Override
    public List<Film> getAll() {
        return films;
    }

    @Override
    public List<Film> getPage(int elementsPerPage, int page) {
        return films.stream()
                .skip((long) elementsPerPage * (page - 1))
                .limit(elementsPerPage)
                .collect(Collectors.toList());
    }

    @Override
    public List<Film> getByName(String name) {
        return films.stream()
                .filter(x -> x.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Film getById(int id) {
        return films.stream()
                .filter(x -> x.getId() == id)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("No such film"));
    }

    @Override
    public void add(Film film) {
        this.films.add(film);
    }

    @Override
    public void change(Film film, int id) {
        Film filmToChange = this.getById(id);
        int index = this.films.indexOf(filmToChange);
        film.setId(id);
        this.films.set(index, film);
    }

    @Override
    public void delete(int id) {
        Film film = this.getById(id);
        this.films.remove(film);
    }
}
