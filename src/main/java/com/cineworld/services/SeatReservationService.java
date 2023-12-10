package com.cineworld.services;

import com.cineworld.entity.SeatReservation;
import com.cineworld.repos.SeatReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatReservationService {

    @Autowired
    private SeatReservationRepository seatReservationRepository;


    // Create a new seat reservation
    public SeatReservation createSeatReservation(SeatReservation seatReservation) {
        return seatReservationRepository.save(seatReservation);
    }

    // Retrieve a seat reservation by ID
    public SeatReservation getSeatReservationById(Long id) {
        return seatReservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid seat reservation ID: " + id));
    }

    // Retrieve all seat reservations
    public List<SeatReservation> getAllSeatReservations() {
        return seatReservationRepository.findAll();
    }

    // Update a seat reservation
    public SeatReservation updateSeatReservation(Long id, SeatReservation seatReservationDetails) {
        SeatReservation seatReservation = seatReservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid seat reservation ID: " + id));

        seatReservation.setSeat(seatReservationDetails.getSeat());
        seatReservation.setShowtime(seatReservationDetails.getShowtime());


        return seatReservationRepository.save(seatReservation);
    }

    // Delete a seat reservation
    public void deleteSeatReservation(Long id) {
        if (!seatReservationRepository.existsById(id)) {
            throw new IllegalArgumentException("Invalid seat reservation ID: " + id);
        }
        seatReservationRepository.deleteById(id);
    }

    // Get all seat reservations for a specific showtime
    public List<SeatReservation> getAllSeatReservationsByShowtimeId(Long showtimeId) {
        return seatReservationRepository.findAllByShowtimeShowtimeId(showtimeId);
    }






}
