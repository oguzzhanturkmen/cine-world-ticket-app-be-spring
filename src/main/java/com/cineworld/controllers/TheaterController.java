package com.cineworld.controllers;

import com.cineworld.entity.Theater;
import com.cineworld.services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/theaters")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    // POST: Create a new theater
    @PostMapping("/")
    public ResponseEntity<Theater> createTheater(@RequestBody Theater theater) {
        try {
            Theater newTheater = theaterService.createTheater(theater);
            return ResponseEntity.ok(newTheater);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null); // Consider more specific error handling
        }
    }

    // GET: Retrieve a specific theater by ID
    @GetMapping("/{id}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable Long id) {
        Theater theater = theaterService.getTheaterById(id);
        return theater != null ? ResponseEntity.ok(theater) : ResponseEntity.notFound().build();
    }

    // GET: Retrieve all theaters
    @GetMapping("/")
    public ResponseEntity<List<Theater>> getAllTheaters() {
        return ResponseEntity.ok(theaterService.getAllTheaters());
    }

    // PUT: Update a specific theater
    @PutMapping("/{id}")
    public ResponseEntity<Theater> updateTheater(@PathVariable Long id, @RequestBody Theater theaterDetails) {
        try {
            Theater updatedTheater = theaterService.updateTheater(id, theaterDetails);
            return ResponseEntity.ok(updatedTheater);
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // Consider more specific error handling
        }
    }

    // DELETE: Delete a specific theater
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheater(@PathVariable Long id) {
        try {
            theaterService.deleteTheater(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // Consider more specific error handling
        }
    }
}
