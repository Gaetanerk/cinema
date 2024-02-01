package fr.gaetan.cinema.film;

import fr.gaetan.cinema.acteur.Acteur;
import fr.gaetan.cinema.realisateur.Realisateur;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FilmService {// on déclare le service
    private final FilmRepository filmRepository;// on déclare le repository

    public FilmService(FilmRepository filmRepository) {// on injecte le repository dans le service

        this.filmRepository = filmRepository;// on initialise le repository
    }

    public List<Film> findAll() {

        return filmRepository.findAll();
    }

    public Film save(Film film) {

        return filmRepository.save(film);
    }

    public Film findById(Integer id) {
        return filmRepository.findById(id)
                .orElseThrow(
                    () -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Film non trouvé")
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

    public Realisateur findRealisateurById(Integer id) {
        Film film = this.findById(id);
        return film.getRealisateur();
    }
}
