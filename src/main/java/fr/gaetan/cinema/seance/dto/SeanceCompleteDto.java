package fr.gaetan.cinema.seance.dto;

import lombok.Data;

@Data
public class SeanceCompleteDto {
    private Integer id;
    private Integer film;
    private Integer salle;
    private String date;
    private float prix;
    private int placesDisponibles;
}
