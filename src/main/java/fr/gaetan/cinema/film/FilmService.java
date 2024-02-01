package fr.gaetan.cinema.film;

import fr.gaetan.cinema.acteur.Acteur;
import fr.gaetan.cinema.acteur.ActeurService;
import fr.gaetan.cinema.film.exception.FilmNotFoundException;
import fr.gaetan.cinema.film.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {// on déclare le service
    private final FilmRepository filmRepository;// on déclare le repository
    private final ActeurService acteurService;

    public FilmService(FilmRepository filmRepository, ActeurService acteurService) {// on injecte le repository dans le service
        this.filmRepository = filmRepository;// on initialise le repository
        this.acteurService = acteurService;
    }

    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    public Film save(Film film) throws BadRequestException {

        List<String> erreurs = new ArrayList<>();

        if (film.getTitre() == null) {
            erreurs.add("Le titre est obligatoire");
        }

        if (film.getDateSortie() == null) {
            erreurs.add("La date de sortie est obligatoire");
        }

        if (film.getRealisateur() == null) {
            erreurs.add("Le realisateur est obligatoire");
        }

        if (!erreurs.isEmpty()) {
            throw new BadRequestException(erreurs);
        }

        return filmRepository.save(film);
    }

    public Film findById(Integer id) {
        return filmRepository.findById(id)
                .orElseThrow(
                        () -> new FilmNotFoundException(id)
            );
    }

    public void deleteById(Integer id) {
        Film film = this.findById(id);
        filmRepository.delete(film);
    }

    public Film update(Film film) {
        return filmRepository.save(film);
    }// on met à jour le film

    public Film findByTitreContains(String titre) {
        return filmRepository.findByTitreContains(titre)
                .orElseThrow(
                    () -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Film non trouvé avec le titre")
            );
    }

    public List<Film> findAllByRealisateurId(Integer id) {
        return filmRepository.findAllByRealisateurId(id)
                .orElseThrow(
                    () -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Film non trouvé avec le realisateur"));
    }

    public List<Acteur> findAllActeursById(Integer id) {
        Film film = this.findById(id);
        return film.getActeurs();
    }

    public Film addActeurToFilm(Integer id, Acteur acteur) throws BadRequestException {
        Film film = this.findById(id);
        acteur = acteurService.findById(acteur.getId());
        film.getActeurs().add(acteur);
        return this.save(film);
    }
}
