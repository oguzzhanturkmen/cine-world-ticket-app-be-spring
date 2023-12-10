package com.cineworld.repos;

import com.cineworld.entity.SeatReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeatReservationRepository extends JpaRepository<SeatReservation, Long> {
    List<SeatReservation> findAllByShowtimeShowtimeId(Long showtimeId);



}
