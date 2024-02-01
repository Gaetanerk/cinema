package fr.gaetan.cinema.seance;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seances")
public class SeanceController {
    private final SeanceService seanceService;

    private final ObjectMapper objectMapper;

    public SeanceController(SeanceService seanceService, ObjectMapper objectMapper) {
        this.seanceService = seanceService;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public Seance save(@RequestBody Seance seance) {
        return seanceService.save(seance);
    }

    @GetMapping
    public List<Seance> findAll() {
        return seanceService.findAll().stream().map(
                seance -> objectMapper.convertValue(seance, Seance.class)
        ).toList();
    }

    @GetMapping("{id}")
    public Seance findById(@PathVariable Integer id) {
        Seance seance = seanceService.findById(id);
        return objectMapper.convertValue(seance, Seance.class);
    }

    @PutMapping
    public Seance update(@RequestBody Seance seance) {
        return seanceService.update(seance);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
        seanceService.deleteById(id);
    }
}
