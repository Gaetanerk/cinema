package fr.gaetan.cinema.seance;

import fr.gaetan.cinema.film.Film;
import fr.gaetan.cinema.salle.Salle;
import fr.gaetan.cinema.ticket.Ticket;
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
    private String film;
    private int salle;
    private LocalDate date;
    private int placesDisponibles;
    private float prix;

    @OneToOne// une séance peut avoir un seul film (One Film To One Seance)
    @JoinColumn(name = "film_id")
    private Film filmSeance;

    @ManyToOne// une salle peut avoir plusieurs séances (Many Seances To One Salle)
    @JoinColumn(name = "salle_id")
    private Salle salleSeance;

    @ManyToOne// une séance peut avoir plusieurs tickets (Many Tickets To One Seance)
    @JoinColumn(name = "ticket_id")
    private Ticket ticketSeance;
}
