package com.daniilmedvediev.cinematicketbooking.repository;

import com.daniilmedvediev.cinematicketbooking.model.Ticket;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByUserId(Long userId);

    @Query("SELECT t FROM Ticket t WHERE t.showtime.id = :showtimeId AND t.status != 'CANCELLED'")
    List<Ticket> findActiveByShowtimeId(Long showtimeId);

    boolean existsByShowtimeIdAndSeatRowAndSeatNumberAndStatusNot(
            Long showtimeId, int seatRow, int seatNumber, Ticket.Status status);
}
