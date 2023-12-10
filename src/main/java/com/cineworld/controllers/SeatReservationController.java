package com.cineworld.controllers;

import com.cineworld.entity.SeatReservation;
import com.cineworld.services.SeatReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seat-reservations")
public class SeatReservationController {

    @Autowired
    private SeatReservationService seatReservationService;

    // POST: Create a new seat reservation
    // GET: Retrieve a specific seat reservation by ID
    // GET: Retrieve all seat reservations
    // PUT: Update a specific seat reservation
    // DELETE: Delete a specific seat reservation
    // GET: Retrieve all seat reservations for a specific showtime
    // Additional methods can be added as per your application's requirements.

    @GetMapping("/")
    public List<SeatReservation> getAllSeatReservations() {
        return seatReservationService.getAllSeatReservations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeatReservation> getSeatReservationById(@PathVariable Long id) {
        try {
            SeatReservation seatReservation = seatReservationService.getSeatReservationById(id);
            return ResponseEntity.ok(seatReservation);
        } catch (Exception e) {
            // Log the exception and return an appropriate error response
        }
        return null;
    }

    @GetMapping("/showtime/{showtimeId}")
    public List<SeatReservation> getAllSeatReservationsByShowtimeId(@PathVariable Long showtimeId) {
        return seatReservationService.getAllSeatReservationsByShowtimeId(showtimeId);
    }

    @PostMapping("/")
    public SeatReservation createSeatReservation(SeatReservation seatReservation) {
        return seatReservationService.createSeatReservation(seatReservation);
    }

    @PutMapping("/{id}")
    public SeatReservation updateSeatReservation(Long id, SeatReservation seatReservationDetails) {
        return seatReservationService.updateSeatReservation(id, seatReservationDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteSeatReservation(Long id) {
        seatReservationService.deleteSeatReservation(id);
    }






}
