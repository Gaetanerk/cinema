package fr.gaetan.cinema.realisateur;

import fr.gaetan.cinema.film.Film;
import fr.gaetan.cinema.film.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RealisateurService {
    private final RealisateurRepository realisateurRepository;
    private final FilmService filmService;

    public RealisateurService(RealisateurRepository realisateurRepository, FilmService filmService) {

        this.realisateurRepository = realisateurRepository;
        this.filmService = filmService;
    }

    public List<Realisateur> findAll() {

        return realisateurRepository.findAll();
    }

    public Realisateur save(Realisateur realisateur) {

        return realisateurRepository.save(realisateur);
    }

    public Realisateur findById(Integer id) {
        return realisateurRepository.findById(id)
                .orElseThrow(
                    () -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Realisateur non trouvé")
        );
    }

    public Realisateur update(Realisateur realisateur) {

        return realisateurRepository.save(realisateur);
    }

    public void deleteById(Integer id) {
        this.findById(id);

        List<Film> filmsAvecCeRealisateur = filmService.findAllByRealisateurId(id);

        filmsAvecCeRealisateur.forEach(
                film -> {
                    film.setRealisateur(null);
                    filmService.save(film);
                }
        );

        realisateurRepository.deleteById(id);
    }
}
