package fr.gaetan.cinema.film;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional

public class _FilmRepository {

    private final EntityManager entityManager;

    public _FilmRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Film> findAll() {// on retourne une liste de film
        return entityManager.createQuery("SELECT f FROM Film f", Film.class).getResultList();
    }

    public Film save(Film film) {// on retourne un film
        entityManager.persist(film);
        entityManager.flush();
        return film;
    }

    public Optional<Film> findById(Integer id) {// soit on trouve le film, soit on trouve rien
        return Optional.ofNullable(entityManager.find(Film.class, id));// on retourne un film
    }

    public void delete(Film film) {// on retourne un film
        entityManager.remove(film);// on supprime le film
    }

    public Film update(Film film) {// on retourne un film
        return entityManager.merge(film);// on met à jour le film
    }
}
