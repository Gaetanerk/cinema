package fr.gaetan.cinema.realisateur;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realisateurs")
public class RealisateurController {
    private final RealisateurService realisateurService;

    public RealisateurController(RealisateurService realisateurService) {
        this.realisateurService = realisateurService;
    }

    @PostMapping
    public Realisateur save(@RequestBody Realisateur realisateur) {

        return realisateurService.save(realisateur);
    }

    @GetMapping
    public List<Realisateur> findAll() {

        return realisateurService.findAll();
    }

    @GetMapping("{id}")
    public Realisateur findById(@PathVariable Integer id) {

        return realisateurService.findById(id);
    }

    @PutMapping
    public Realisateur update(@RequestBody Realisateur realisateur) {

        return realisateurService.update(realisateur);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {

        realisateurService.deleteById(id);
    }
}
