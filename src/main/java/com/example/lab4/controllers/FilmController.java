package com.example.lab4.controllers;

import com.example.lab4.models.Film;
import com.example.lab4.services.interfaces.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/films")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping
    public ResponseEntity<List<Film>> getAll() {
        List<Film> films = filmService.getAllFilms();
        return ResponseEntity.ok(films);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getById(@PathVariable int id) {
        try {
            Film film = filmService.getById(id);
            return ResponseEntity.ok(film);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/page/{page}")
    public ResponseEntity<List<Film>> getPage(@PathVariable("page") int page) {
        List<Film> films = filmService.getPage(page);
        return ResponseEntity.ok(films);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Film>> getByName(@PathVariable String name) {
        List<Film> films = filmService.getByName(name);
        return ResponseEntity.ok(films);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addFilm(@RequestBody Film film) {
        filmService.add(film);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Film> deleteFilm(@PathVariable int id) {
        try {
            filmService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Film> changeFilm(@RequestBody Film film,
                                           @PathVariable int id
    ) {
        try {
            filmService.change(film, id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
