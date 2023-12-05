package com.cineworld.services;

import com.cineworld.entity.Showtime;
import com.cineworld.entity.Theater;
import com.cineworld.repos.ShowtimeRepository;
import com.cineworld.repos.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<Showtime> getShowtimesByMovieId(Long id) {
        return showtimeRepository.findAllByMovieId(id);
    }

    public List<Theater> getTheatersByMovieId(Long id) {


       List<Theater> list =  showtimeRepository.findAllByMovieId(id).stream().map(Showtime::getTheater).toList();
        Map<String, Theater> uniqueTheatersMap = list.stream()
                .collect(Collectors.toMap(Theater::getName, theater -> theater, (theater1, theater2) -> theater1));

        return new ArrayList<>(uniqueTheatersMap.values());
    }

    // get showtimes by theater id and movie id
    public List<Showtime> getShowtimesByTheaterIdAndMovieId(Long theaterId, Long movieId) {
        return showtimeRepository.findAllByTheater_IdAndMovieId(theaterId, movieId);
    }


}


