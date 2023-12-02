package com.cineworld.controllers;

import com.cineworld.entity.Screen;
import com.cineworld.services.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/screens")
public class ScreenController {

    @Autowired
    private ScreenService screenService;

    // Create a new screen
    @PostMapping("/")
    public ResponseEntity<Screen> createScreen(@RequestBody Screen screen) {
        Screen newScreen = screenService.createScreen(screen);
        return ResponseEntity.ok(newScreen);
    }

    // Get a single screen by ID
    @GetMapping("/{id}")
    public ResponseEntity<Screen> getScreenById(@PathVariable Long id) {
        Screen screen = screenService.getScreenById(id);
        if (screen == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(screen);
    }

    // Get all screens
    @GetMapping("/")
    public List<Screen> getAllScreens() {
        return screenService.getAllScreens();
    }

    // Update a screen
    @PutMapping("/{id}")
    public ResponseEntity<Screen> updateScreen(@PathVariable Long id, @RequestBody Screen screenDetails) {
        try {
            Screen updatedScreen = screenService.updateScreen(id, screenDetails);
            return ResponseEntity.ok(updatedScreen);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a screen
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScreen(@PathVariable Long id) {
        try {
            screenService.deleteScreen(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

