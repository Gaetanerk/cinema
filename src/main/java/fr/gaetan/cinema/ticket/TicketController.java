package fr.gaetan.cinema.ticket;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    private final ObjectMapper objectMapper;

    public TicketController(TicketService ticketService, ObjectMapper objectMapper) {
        this.ticketService = ticketService;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public Ticket save(@RequestBody Ticket ticket) {
        return ticketService.save(ticket);
    }

    @GetMapping
    public List<Ticket> findAll() {
        return ticketService.findAll().stream().map(
                ticket -> objectMapper.convertValue(ticket, Ticket.class)
        ).toList();
    }

    @GetMapping("{id}")
    public Ticket findById(@PathVariable Integer id) {
        Ticket ticket = ticketService.findById(id);
        return objectMapper.convertValue(ticket, Ticket.class);
    }

    @PutMapping
    public Ticket update(@RequestBody Ticket ticket) {
        return ticketService.update(ticket);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
        ticketService.deleteById(id);
    }
}
