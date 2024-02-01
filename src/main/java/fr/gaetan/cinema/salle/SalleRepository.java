package fr.gaetan.cinema.salle;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalleRepository extends JpaRepository<Salle, Integer> {
}
