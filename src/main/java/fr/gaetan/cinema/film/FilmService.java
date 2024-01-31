package fr.gaetan.cinema.film;

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

    public void deleteById(Integer id) {// on retourne un film
        Film film = this.findById(id);// on vérifie que le film existe
        filmRepository.delete(film);
    }

    public Film update(Film film) {
        return filmRepository.save(film);
    }// on met à jour le film

    public Film findByTitreContains(String titre) {// on retourne un film
        return filmRepository.findByTitreContains(titre)// on vérifie que le film existe
                .orElseThrow(// si le film n'existe pas, on renvoie une erreur
                    () -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Film non trouvé avec le titre")
            );
    }
}
