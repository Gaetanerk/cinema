package fr.gaetan.cinema.seance.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SeanceAvecFilmSalleDatePrixDto {
    private Integer film;
    private Integer salle;
    private LocalDate date;
    private float prix;
}
