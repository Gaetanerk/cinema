package fr.gaetan.cinema.film.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmAvecTitreDateSortieDto {
    private String titre;
    private LocalDate dateSortie;
}
