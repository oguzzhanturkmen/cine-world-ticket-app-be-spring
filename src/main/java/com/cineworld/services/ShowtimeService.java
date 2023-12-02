package com.cineworld.services;

import com.cineworld.entity.Showtime;
import com.cineworld.repos.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ShowtimeService {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    // Create a new showtime
    public Showtime createShowtime(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    // Retrieve a showtime by ID
    public Showtime getShowtimeById(Long id) {
        return showtimeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid showtime ID: " + id));
    }

    // Retrieve all showtimes
    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    // Update a showtime
    public Showtime updateShowtime(Long id, Showtime showtimeDetails) {
        Showtime showtime = showtimeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid showtime ID: " + id));

        showtime.setDateTime(showtimeDetails.getDateTime());
        showtime.setMovie(showtimeDetails.getMovie());
        showtime.setTheater(showtimeDetails.getTheater());
        showtime.setScreen(showtimeDetails.getScreen());
        // ... update other fields as necessary

        return showtimeRepository.save(showtime);
    }

    // Delete a showtime
    public void deleteShowtime(Long id) {
        if (!showtimeRepository.existsById(id)) {
            throw new IllegalArgumentException("Invalid showtime ID: " + id);
        }
        showtimeRepository.deleteById(id);
    }

    // Additional methods can be added as per your application's requirements.
}

