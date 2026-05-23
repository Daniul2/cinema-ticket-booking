package com.daniilmedvediev.cinematicketbooking.repository;

import com.daniilmedvediev.cinematicketbooking.model.Showtime;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    List<Showtime> findAllByMovieIdAndStartTimeAfter(Long movieId, LocalDateTime after);
}
