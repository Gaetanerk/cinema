package fr.gaetan.cinema.seance;

import fr.gaetan.cinema.film.Film;
import fr.gaetan.cinema.salle.Salle;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Seance {
    @Id
    @GeneratedValue
    private Integer id;
    private LocalDate date;
    private int placesDisponibles;
    private float prix;

    @OneToOne// une séance peut avoir un seul film (One Film To One Seance)
    private Film film;

    @ManyToOne// une salle peut avoir plusieurs séances (Many Seances To One Salle)
    private Salle salle;
}
