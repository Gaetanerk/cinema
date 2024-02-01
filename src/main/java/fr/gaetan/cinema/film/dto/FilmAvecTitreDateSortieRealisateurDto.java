package fr.gaetan.cinema.film.dto;

import fr.gaetan.cinema.realisateur.dto.RealisateurSansIdDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmAvecTitreDateSortieRealisateurDto {
    private String titre;
    private LocalDate dateSortie;
    private RealisateurSansIdDto realisateur;
}
