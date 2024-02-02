package fr.gaetan.cinema.seance.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SeanceAvecFilmSalleDatePrixDto {
    private int film;
    private int salle;
    private LocalDate date;
    private float prix;
}
