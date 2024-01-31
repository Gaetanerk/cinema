package fr.gaetan.cinema.realisateur;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RealisateurService {
    private final RealisateurRepository realisateurRepository;

    public RealisateurService(RealisateurRepository realisateurRepository) {

        this.realisateurRepository = realisateurRepository;
    }

    public List<Realisateur> findAll() {

        return realisateurRepository.findAll();
    }

    public Realisateur save(Realisateur realisateur) {

        return realisateurRepository.save(realisateur);
    }

    public Realisateur findById(Integer id) {
        return realisateurRepository.findById(id)
                .orElseThrow(
                    () -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Realisateur non trouvé")
        );
    }

    public Realisateur update(Realisateur realisateur) {

        return realisateurRepository.save(realisateur);
    }

    public void deleteById(Integer id) {
        Realisateur realisateur = this.findById(id);
        realisateurRepository.delete(realisateur);
    }
}
