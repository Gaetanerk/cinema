package fr.gaetan.cinema.film;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    Optional<Film> findByTitre(String titre);// cherche un film par son titre stricte
    Optional<Film> findByTitreContains(String titre);// cherche un film par son titre s'il contient
    Optional<Film> findByDateSortieAfter(LocalDate dateSortie);
    Optional<List<Film>> findAllByRealisateurId(Integer id);
}
