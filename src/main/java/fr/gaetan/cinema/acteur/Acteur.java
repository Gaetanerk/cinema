package fr.gaetan.cinema.acteur;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.gaetan.cinema.film.Film;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity// on déclare que c'est une entité
@Getter// on déclare les getters
@Setter// on déclare les setters
@NoArgsConstructor// on déclare le constructeur vide
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Acteur {
    @Id// on déclare la clé primaire
    @GeneratedValue// on déclare l'auto-incrémentation
    private Integer id;
    private String nom;
    private String prenom;

    @ManyToMany(mappedBy = "acteurs")// on déclare le nom de la variable qui va faire la liaison
    private List<Film> films = new ArrayList<>();// on déclare une liste de film
}
