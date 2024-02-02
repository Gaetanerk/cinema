package fr.gaetan.cinema.ticket;

import fr.gaetan.cinema.seance.Seance;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue
    private Integer id;
    private int seance;
    private String nomClient;
    private int nbPlaces;

}
