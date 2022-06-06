package com.example.lab4.services.implementations;

import com.example.lab4.models.Film;
import com.example.lab4.repositories.interfaces.FilmRepository;
import com.example.lab4.services.interfaces.FilmService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    FilmRepository repository;
    int indexGenerator = 3;

    public FilmServiceImpl(FilmRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Film> getAllFilms() {
        return repository.getAll();
    }

    @Override
    public Film getById(int id) {
        return this.repository.getById(id);
    }

    @Override
    public List<Film> getPage(int page) {
        return this.repository.getPage(2, page);
    }

    @Override
    public List<Film> getByName(String name) {
        return this.repository.getByName(name);
    }

    @Override
    public void add(Film film) {
        film.setId(indexGenerator++);
        this.repository.add(film);
    }

    @Override
    public void change(Film film, int id) {
        this.repository.change(film, id);
    }

    @Override
    public void delete(int id) {
        this.repository.delete(id);
    }
}
