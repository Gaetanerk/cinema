package fr.gaetan.cinema.realisateur;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gaetan.cinema.film.Film;
import fr.gaetan.cinema.film.FilmRepository;
import fr.gaetan.cinema.film.FilmService;
import fr.gaetan.cinema.realisateur.dto.RealisateurNomPrenomFilmsDto;
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

    @GetMapping("{id}")
    public RealisateurNomPrenomFilmsDto findById(@PathVariable Integer id) {
        Realisateur realisateur = realisateurService.findById(id);
        return objectMapper.convertValue(realisateur, RealisateurNomPrenomFilmsDto.class);
    }

    @PutMapping
    public Realisateur update(@RequestBody Realisateur realisateur) {

        return realisateurService.update(realisateur);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {

        realisateurService.deleteById(id);
    }
}
