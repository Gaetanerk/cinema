package fr.gaetan.cinema.film;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gaetan.cinema.acteur.dto.ActeurSansIdDto;
import fr.gaetan.cinema.film.dto.FilmCompletDto;
import fr.gaetan.cinema.film.dto.FilmReduitDto;
import fr.gaetan.cinema.realisateur.Realisateur;
import fr.gaetan.cinema.realisateur.dto.RealisateurSansIdDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController// on déclare le controller
@RequestMapping("/films")// on déclare le chemin
public class FilmController {
    private final FilmService filmService;// on déclare le service

    private final ObjectMapper objectMapper;

    public FilmController(FilmService filmService, ObjectMapper objectMapper) {// on injecte le service
        this.filmService = filmService;// on initialise le service
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<FilmReduitDto> findAll() {
        return filmService.findAll().stream().map(
                film -> objectMapper.convertValue(film, FilmReduitDto.class)
        ).toList();
    }

    @PostMapping
    public Film save(@RequestBody Film film) {
        return filmService.save(film);
    }

    @GetMapping("/{id}")// /films/1
    public FilmCompletDto findById(@PathVariable Integer id) {
        Film film = filmService.findById(id);
        return objectMapper.convertValue(film, FilmCompletDto.class);
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

    @GetMapping("/{id}/acteurs")
    public List<ActeurSansIdDto> findAllActeursById(@PathVariable Integer id) {
        return filmService.findAllActeursById(id).stream().map(
                acteurs -> objectMapper.convertValue(acteurs, ActeurSansIdDto.class)
        ).toList();
    }

    @GetMapping("/{id}/realisateur")
    public RealisateurSansIdDto findRealisateurById(@PathVariable Integer id) {
        Realisateur realisateur = filmService.findRealisateurById(id);
        return objectMapper.convertValue(realisateur, RealisateurSansIdDto.class);
    }
}
