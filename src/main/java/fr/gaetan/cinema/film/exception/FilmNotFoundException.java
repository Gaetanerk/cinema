package fr.gaetan.cinema.film.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FilmNotFoundException extends RuntimeException {
    public FilmNotFoundException(Integer idDuFilm) {
        super("Film non trouvé avec l'id " + idDuFilm);
    }
}
