package com.daniilmedvediev.cinematicketbooking.controller;

import com.daniilmedvediev.cinematicketbooking.service.TicketService;
import com.daniilmedvediev.cinematicketbooking.model.Ticket;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket book(@RequestParam Long showtimeId,
                       @RequestParam Long userId,
                       @RequestParam int seatRow,
                       @RequestParam int seatNumber) {
        return ticketService.bookTicket(showtimeId, userId, seatRow, seatNumber);
    }

    @PutMapping("/{id}/cancel")
    public Ticket cancel(@PathVariable Long id) {
        return ticketService.cancelTicket(id);
    }

    @GetMapping("/showtime/{showtimeId}")
    public List<Ticket> getByShowtime(@PathVariable Long showtimeId) {
        return ticketService.getActiveTickets(showtimeId);
    }
}
