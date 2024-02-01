package fr.gaetan.cinema.salle;

import fr.gaetan.cinema.salle.dto.SalleCapaciteDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SalleService {
    private final SalleRepository salleRepository;

    public SalleService(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    public List<Salle> findAll() {
        return salleRepository.findAll();
    }

    public Salle save(Salle salle) {
        return salleRepository.save(salle);
    }

    public Salle findById(Integer id) {
        return salleRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Salle non trouvée")
                );
    }

    public Salle update(Salle salle) {

        return salleRepository.save(salle);
    }

    public void deleteById(Integer id) {
        Salle salle = this.findById(id);
        salleRepository.delete(salle);
    }

    public SalleCapaciteDto findCapaciteBySalleId(Integer id) {
        Salle salle = this.findById(id);

        SalleCapaciteDto salleCapaciteDto = new SalleCapaciteDto();

        salleCapaciteDto.setCapacite(salle.getCapacite());

        return salleCapaciteDto;
    }
}
