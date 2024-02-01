package fr.gaetan.cinema.acteur;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gaetan.cinema.acteur.dto.ActeurAvecFilmsDto;
import fr.gaetan.cinema.acteur.dto.ActeurSansFilmDto;
import fr.gaetan.cinema.film.Film;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acteurs")
public class ActeurController {
    private final ActeurService acteurService;
    
    private final ObjectMapper objectMapper;

    public ActeurController(ActeurService acteurService, ObjectMapper objectMapper) {
        this.acteurService = acteurService;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public Acteur save(@RequestBody Acteur acteur) {

        return acteurService.save(acteur);
    }

    @GetMapping
    public List<ActeurSansFilmDto> findAll() {
        return acteurService.findAll().stream().map(
                acteur -> objectMapper.convertValue(acteur, ActeurSansFilmDto.class)
        ).toList();
    }

    @GetMapping("{id}")
    public ActeurAvecFilmsDto findById(@PathVariable Integer id) {
        Acteur acteur = acteurService.findById(id);
        return objectMapper.convertValue(acteur, ActeurAvecFilmsDto.class);
    }

    @PutMapping
    public Acteur update(@RequestBody Acteur acteur) {
        return acteurService.update(acteur);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
        acteurService.deleteById(id);
    }
}
