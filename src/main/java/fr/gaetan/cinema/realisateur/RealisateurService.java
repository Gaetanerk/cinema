package fr.gaetan.cinema.realisateur;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gaetan.cinema.film.Film;
import fr.gaetan.cinema.film.FilmService;
import fr.gaetan.cinema.film.dto.FilmAvecTitreDateSortieDto;
import fr.gaetan.cinema.realisateur.dto.RealisateurAvecFilmsDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RealisateurService {
    private final RealisateurRepository realisateurRepository;
    private final FilmService filmService;
    private final ObjectMapper objectMapper;

    public RealisateurService(RealisateurRepository realisateurRepository,
                              FilmService filmService,
                              ObjectMapper objectMapper) {

        this.realisateurRepository = realisateurRepository;
        this.filmService = filmService;
        this.objectMapper = objectMapper;
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

    public RealisateurAvecFilmsDto findRealisateurWithFilm(Integer id) {
        Realisateur realisateur = this.findById(id);
        List<Film> filmsDuRealisateur = filmService.findAllByRealisateurId(id);

        RealisateurAvecFilmsDto realisateurAvecFilmsDto = new RealisateurAvecFilmsDto();

        realisateurAvecFilmsDto.setNom(realisateur.getNom());
        realisateurAvecFilmsDto.setPrenom(realisateur.getPrenom());

        realisateurAvecFilmsDto.setFilms(
                filmsDuRealisateur.stream().map(
                        film -> objectMapper.convertValue(film, FilmAvecTitreDateSortieDto.class)
                ).toList()
        );

        return realisateurAvecFilmsDto;
    }


    public List<Film> findFilmsByRealisateurId(Integer id) {
        return filmService.findAllByRealisateurId(id);
    }
}
