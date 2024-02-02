package fr.gaetan.cinema.seance;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gaetan.cinema.film.Film;
import fr.gaetan.cinema.film.FilmService;
import fr.gaetan.cinema.salle.Salle;
import fr.gaetan.cinema.salle.SalleService;
import fr.gaetan.cinema.seance.dto.SeanceAvecFilmSalleDatePrixDto;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seances")
public class SeanceController {
    private final SeanceService seanceService;
    private final FilmService filmService;
    private final SalleService salleService;
    private final ObjectMapper objectMapper;

    public SeanceController(SeanceService seanceService,
                            FilmService filmService,
                            SalleService salleService,
                            ObjectMapper objectMapper) {
        this.seanceService = seanceService;
        this.filmService = filmService;
        this.salleService = salleService;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SeanceAvecFilmSalleDatePrixDto save(@RequestBody Integer idFilm,
                                               @RequestBody Integer idSalle,
                                               @RequestBody Seance seance)
                                                throws BadRequestException {
        Film film = filmService.findById(idFilm);
        Salle salle = salleService.findById(idSalle);
        SeanceAvecFilmSalleDatePrixDto seanceAvecFilmSalleDatePrixDto = new SeanceAvecFilmSalleDatePrixDto();
        seanceAvecFilmSalleDatePrixDto.setFilm(film.getId());
        seanceAvecFilmSalleDatePrixDto.setSalle(salle.getId());
        seanceAvecFilmSalleDatePrixDto.setDate(seance.getDate());
        seanceAvecFilmSalleDatePrixDto.setPrix(seance.getPrix());
        return seanceAvecFilmSalleDatePrixDto;
    }

    @GetMapping
    public List<Seance> findAll() {
        return seanceService.findAll().stream().map(
                seance -> objectMapper.convertValue(seance, Seance.class)
        ).toList();
    }

    @GetMapping("{id}")
    public Seance findById(@PathVariable Integer id) {
        Seance seance = seanceService.findById(id);
        return objectMapper.convertValue(seance, Seance.class);
    }

    @PutMapping
    public Seance update(@RequestBody Seance seance) {
        return seanceService.update(seance);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
        seanceService.deleteById(id);
    }
}
