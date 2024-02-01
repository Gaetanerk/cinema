package fr.gaetan.cinema.realisateur.dto;

import fr.gaetan.cinema.film.dto.FilmAvecTitreDateSortieDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RealisateurNomPrenomFilmsDto {
    private String nom;
    private String prenom;
    private List<FilmAvecTitreDateSortieDto> films = new ArrayList<>();
}
