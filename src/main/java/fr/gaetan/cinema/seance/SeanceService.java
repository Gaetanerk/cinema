package fr.gaetan.cinema.seance;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SeanceService {
    private final SeanceRepository seanceRepository;

    public SeanceService(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    public List<Seance> findAll() {
        return seanceRepository.findAll();
    }

    public Seance save(Seance seance) {
        return seanceRepository.save(seance);
    }

    public Seance findById(Integer id) {
        return seanceRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Salle non trouvée")
                );
    }

    public Seance update(Seance seance) {

        return seanceRepository.save(seance);
    }

    public void deleteById(Integer id) {
        Seance seance = this.findById(id);
        seanceRepository.delete(seance);
    }
}
