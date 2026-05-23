package com.daniilmedvediev.cinematicketbooking.service;

import com.daniilmedvediev.cinematicketbooking.model.Showtime;
import com.daniilmedvediev.cinematicketbooking.model.Ticket;
import com.daniilmedvediev.cinematicketbooking.model.User;
import com.daniilmedvediev.cinematicketbooking.repository.ShowtimeRepository;
import com.daniilmedvediev.cinematicketbooking.repository.TicketRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final ShowtimeRepository showtimeRepository;

    @Transactional
    public Ticket bookTicket(Long showtimeId, Long userId, int seatRow, int seatNumber) {
        boolean isTaken = ticketRepository.existsByShowtimeIdAndSeatRowAndSeatNumberAndStatusNot(
                showtimeId, seatRow, seatNumber, Ticket.Status.CANCELLED);
        if (isTaken) {
            throw new RuntimeException("Seat " + seatRow + "-" + seatNumber + " is already booked");
        }

        Showtime showtime = showtimeRepository.findById(showtimeId)
                .orElseThrow(() -> new RuntimeException("Showtime not found"));

        Ticket ticket = new Ticket();
        ticket.setShowtime(showtime);
        User user = new User();
        user.setId(userId);
        ticket.setUser(user);
        ticket.setSeatRow(seatRow);
        ticket.setSeatNumber(seatNumber);
        ticket.setStatus(Ticket.Status.RESERVED);
        return ticketRepository.save(ticket);
    }

    @Transactional
    public Ticket cancelTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticket.setStatus(Ticket.Status.CANCELLED);
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getActiveTickets(Long showtimeId) {
        return ticketRepository.findActiveByShowtimeId(showtimeId);
    }
}
