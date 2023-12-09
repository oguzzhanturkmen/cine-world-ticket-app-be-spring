package com.cineworld.services;

import com.cineworld.entity.Seat;
import com.cineworld.repos.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    // Create a new seat
    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    // Retrieve a seat by ID
    public Seat getSeatById(Long id) {
        return seatRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid seat ID: " + id));
    }

    // Retrieve all seats
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    // Update a seat
    public Seat updateSeat(Long id, Seat seatDetails) {
        Seat seat = seatRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid seat ID: " + id));

        seat.setScreen(seatDetails.getScreen());
        seat.setSeatNumber(seatDetails.getSeatNumber());
        seat.setStatus(seatDetails.getStatus());
        // ... update other fields as necessary

        return seatRepository.save(seat);
    }

    // Delete a seat
    public void deleteSeat(Long id) {
        if (!seatRepository.existsById(id)) {
            throw new IllegalArgumentException("Invalid seat ID: " + id);
        }
        seatRepository.deleteById(id);
    }

    public List<Seat> getSeatsByScreenId(Long screenId) {
        return seatRepository.findByScreenId(screenId);
    }

    public List<Seat> getSeatsByIds(List<Long> ids) {
        return seatRepository.findByIdIn(ids);
    }

    // Additional methods can be added as per your application's requirements.
}

