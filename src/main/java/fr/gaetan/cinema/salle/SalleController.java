package fr.gaetan.cinema.salle;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gaetan.cinema.salle.dto.SalleCapaciteDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salles")
public class SalleController {
    private final SalleService salleService;

    private final ObjectMapper objectMapper;

    public SalleController(SalleService salleService, ObjectMapper objectMapper) {
        this.salleService = salleService;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public Salle save(@RequestBody Salle salle) {
        return salleService.save(salle);
    }

    @GetMapping
    public List<Salle> findAll() {
        return salleService.findAll().stream().map(
                salle -> objectMapper.convertValue(salle, Salle.class)
        ).toList();
    }

    @GetMapping("{id}")
    public Salle findById(@PathVariable Integer id) {
        Salle salle = salleService.findById(id);
        return objectMapper.convertValue(salle, Salle.class);
    }

    @PutMapping
    public Salle update(@RequestBody Salle salle) {
        return salleService.update(salle);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
        salleService.deleteById(id);
    }

    @GetMapping("{id}/capacite")
    public SalleCapaciteDto findCapaciteBySalleId(@PathVariable Integer id) {
        return salleService.findCapaciteBySalleId(id);
    }
}
