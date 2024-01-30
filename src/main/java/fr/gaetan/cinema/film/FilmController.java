package fr.gaetan.cinema.film;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController// on déclare le controller
@RequestMapping("/films")// on déclare le chemin
public class FilmController {// on déclare le controller
    private final FilmService filmService;// on déclare le service

    public FilmController(FilmService filmService) {// on injecte le service
        this.filmService = filmService;
    }

    @GetMapping
    public List<Film> findAll() {// on retourne une liste de film
        return filmService.findAll();
    }

    @PostMapping
    public Film save(@RequestBody Film film) {// on retourne un film
        return filmService.save(film);
    }

    @GetMapping("/{id}")// /films/1
    public Film findById(@PathVariable Integer id) {// on retourne un film
        return filmService.findById(id);
    }

    @DeleteMapping("/{id}")// /films/1
    public void deleteById(@PathVariable Integer id) {// on retourne un film
        filmService.deleteById(id);
    }

    @PutMapping
    public Film update(@RequestBody Film film) {// on retourne un film
        return filmService.update(film);// on met à jour le film
    }

    @GetMapping("/search")// /films/search?titre=Star Wars
    public Film findByTitreContains(@RequestParam String titre) {// on retourne un film
        return filmService.findByTitreContains(titre);
    }
}
