package fr.gaetan.cinema.film;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController// on déclare le controller
@RequestMapping("/films")// on déclare le chemin
public class FilmController {
    private final FilmService filmService;// on déclare le service

    public FilmController(FilmService filmService) {// on injecte le service
        this.filmService = filmService;// on initialise le service
    }

    @GetMapping
    public List<Film> findAll() {// on retourne une liste de film

        return filmService.findAll();
    }

    @PostMapping
    public Film save(@RequestBody Film film) {
        return filmService.save(film);
    }

    @GetMapping("/{id}")// /films/1
    public Film findById(@PathVariable Integer id) {

        return filmService.findById(id);
    }

    @DeleteMapping("/{id}")// /films/1
    public void deleteById(@PathVariable Integer id) {

        filmService.deleteById(id);
    }

    @PutMapping
    public Film update(@RequestBody Film film) {

        return filmService.update(film);
    }

    @GetMapping("/search")// /films/search?titre=Star Wars
    public Film findByTitreContains(@RequestParam String titre) {

        return filmService.findByTitreContains(titre);
    }
}
