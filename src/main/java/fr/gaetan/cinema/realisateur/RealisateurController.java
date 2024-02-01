package fr.gaetan.cinema.realisateur;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gaetan.cinema.film.Film;
import fr.gaetan.cinema.film.dto.FilmsSansActeurNiRealisateurDto;
import fr.gaetan.cinema.realisateur.dto.RealisateurAvecFilmsDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realisateurs")
public class RealisateurController {
    private final RealisateurService realisateurService;

    private final ObjectMapper objectMapper;

    public RealisateurController(RealisateurService realisateurService,
                                 ObjectMapper objectMapper) {
        this.realisateurService = realisateurService;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public Realisateur save(@RequestBody Realisateur realisateur) {
        return realisateurService.save(realisateur);
    }

    @GetMapping
    public List<Realisateur> findAll() {

        return realisateurService.findAll();
    }

    @GetMapping("/{id}")
    public RealisateurAvecFilmsDto findById(@PathVariable int id) {
        return realisateurService.findRealisateurWithFilm(id);
    }

    @PutMapping
    public Realisateur update(@RequestBody Realisateur realisateur) {

        return realisateurService.update(realisateur);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {

        realisateurService.deleteById(id);
    }

    @GetMapping("/{id}/films")
    public List<FilmsSansActeurNiRealisateurDto> findFilmsByRealisateurId(@PathVariable Integer id) {
        List<Film> filmsDuRealisateur = realisateurService.findFilmsByRealisateurId(id);

        return filmsDuRealisateur.stream().map(
                film -> objectMapper.convertValue(film, FilmsSansActeurNiRealisateurDto.class)
        ).toList();
    }
}
