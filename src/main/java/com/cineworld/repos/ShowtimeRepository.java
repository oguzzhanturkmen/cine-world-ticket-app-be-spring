package com.cineworld.repos;

import com.cineworld.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {

    List<Showtime> findAllByMovieId(Long id);
}
