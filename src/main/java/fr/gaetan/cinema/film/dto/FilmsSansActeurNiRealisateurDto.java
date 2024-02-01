package fr.gaetan.cinema.film.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmsSansActeurNiRealisateurDto {
    private String titre;
    private int duree;
    private LocalDate dateSortie;
}
