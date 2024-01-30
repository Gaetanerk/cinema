package fr.gaetan.cinema.acteur;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acteurs")
public class ActeurController {
    private final ActeurService acteurService;

    public ActeurController(ActeurService acteurService) {

        this.acteurService = acteurService;
    }

    @PostMapping
    public Acteur save(@RequestBody Acteur acteur) {

        return acteurService.save(acteur);
    }

    @GetMapping
    public List<Acteur> findAll() {

        return acteurService.findAll();
    }

    @GetMapping("{id}")
    public Acteur findById(@PathVariable Integer id) {

        return acteurService.findById(id);
    }

    @PutMapping
    public Acteur update(@RequestBody Acteur acteur) {
        return acteurService.update(acteur);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {

        acteurService.deleteById(id);
    }
}
