package com.cineworld.services;

import com.cineworld.entity.Theater;
import com.cineworld.repos.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    // Create a new theater
    public Theater createTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    // Retrieve a theater by ID
    public Theater getTheaterById(Long id) {
        return theaterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid theater ID: " + id));
    }

    // Retrieve all theaters
    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    // Update a theater
    public Theater updateTheater(Long id, Theater theaterDetails) {
        Theater theater = theaterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid theater ID: " + id));

        theater.setName(theaterDetails.getName());
        theater.setLocation(theaterDetails.getLocation());
        theater.setNumberOfScreens(theaterDetails.getNumberOfScreens());
        // ... update other fields as necessary

        return theaterRepository.save(theater);
    }

    // Delete a theater
    public void deleteTheater(Long id) {
        if (!theaterRepository.existsById(id)) {
            throw new IllegalArgumentException("Invalid theater ID: " + id);
        }
        theaterRepository.deleteById(id);
    }

    // Additional methods can be added as per your application's requirements.
}

