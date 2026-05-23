package com.daniilmedvediev.cinematicketbooking.repository;

import com.daniilmedvediev.cinematicketbooking.model.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByGenreIgnoreCase(String genre);
}
