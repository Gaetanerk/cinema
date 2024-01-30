package fr.gaetan.cinema.film;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.gaetan.cinema.acteur.Acteur;
import fr.gaetan.cinema.realisateur.Realisateur;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "film")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Film {
    @Id// on déclare la clé primaire
    @GeneratedValue// on déclare l'auto-incrémentation
    private Integer id;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private LocalDate dateSortie;

    @Column(nullable = false)
    private int duree;

    @Column(length = 500)
    private String synopsis;

    @ManyToOne(cascade = CascadeType.ALL)// un réalisateur peut avoir plusieurs films (Many Films To One Realisateur)
    @JoinColumn(name = "realisateur_id")// on déclare la colonne qui va faire la liaison
    private Realisateur realisateur;//

    @ManyToMany(cascade = CascadeType.PERSIST)// un acteur peut avoir plusieurs films et un film peut avoir plusieurs acteurs (Many Films To Many Acteurs)
    @JoinTable(// on déclare la table de liaison
            name = "acteur_film",// on déclare le nom de la table de liaison
            joinColumns = @JoinColumn(name = "film_id"),// on déclare la colonne qui va faire la liaison
            inverseJoinColumns = @JoinColumn(name = "acteur_id")// on déclare la colonne qui va faire la liaison
    )
    private List<Acteur> acteurs = new ArrayList<>();
}
