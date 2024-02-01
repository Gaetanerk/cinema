package fr.gaetan.cinema.acteur.dto;

import fr.gaetan.cinema.film.dto.FilmAvecTitreDateSortieRealisateurDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ActeurAvecFilmsDto {
    private String nom;
    private String prenom;
    private List<FilmAvecTitreDateSortieRealisateurDto> films = new ArrayList<>();
}
