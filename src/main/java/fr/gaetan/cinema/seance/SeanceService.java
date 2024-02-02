package fr.gaetan.cinema.seance;

import fr.gaetan.cinema.film.Film;
import fr.gaetan.cinema.film.FilmService;
import fr.gaetan.cinema.salle.Salle;
import fr.gaetan.cinema.salle.SalleService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SeanceService {
    private final SeanceRepository seanceRepository;

    private final FilmService filmService;
    private final SalleService salleService;

    public SeanceService(SeanceRepository seanceRepository,
                         FilmService filmService,
                         SalleService salleService) {
        this.seanceRepository = seanceRepository;
        this.filmService = filmService;
        this.salleService = salleService;
    }

    public List<Seance> findAll() {
        return seanceRepository.findAll();
    }

    public Seance save(Integer id) {
        Seance seance = this.findById(id);
        return seanceRepository.save(seance);
    }

    public Seance findById(Integer id) {
        return seanceRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Salle non trouvée")
                );
    }

    public Seance update(Seance seance) {

        return seanceRepository.save(seance);
    }

    public void deleteById(Integer id) {
        Seance seance = this.findById(id);
        seanceRepository.delete(seance);
    }
}
