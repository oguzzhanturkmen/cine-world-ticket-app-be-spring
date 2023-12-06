package com.cineworld.controllers;

import com.cineworld.entity.Seat;
import com.cineworld.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    // POST: Create a new seat
    @PostMapping("/")
    public ResponseEntity<Seat> createSeat(@RequestBody Seat seat) {
        try {
            Seat newSeat = seatService.createSeat(seat);
            return ResponseEntity.ok(newSeat);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null); // Consider more specific error handling
        }
    }

    // GET: Retrieve a specific seat by ID
    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable Long id) {
        Seat seat = seatService.getSeatById(id);
        return seat != null ? ResponseEntity.ok(seat) : ResponseEntity.notFound().build();
    }

    // GET: Retrieve all seats
    @GetMapping("/")
    public ResponseEntity<List<Seat>> getAllSeats() {
        return ResponseEntity.ok(seatService.getAllSeats());
    }

    // PUT: Update a specific seat
    @PutMapping("/{id}")
    public ResponseEntity<Seat> updateSeat(@PathVariable Long id, @RequestBody Seat seatDetails) {
        try {
            Seat updatedSeat = seatService.updateSeat(id, seatDetails);
            return ResponseEntity.ok(updatedSeat);
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // Consider more specific error handling
        }
    }

    // DELETE: Delete a specific seat
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeat(@PathVariable Long id) {
        try {
            seatService.deleteSeat(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // Consider more specific error handling
        }
    }
    @GetMapping("/screen/{screenId}")
    public ResponseEntity<List<Seat>> getSeatsByScreenId(@PathVariable Long screenId) {
        return ResponseEntity.ok(seatService.getSeatsByScreenId(screenId));
    }
}

