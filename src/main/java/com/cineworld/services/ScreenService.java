package com.cineworld.services;

import com.cineworld.entity.Screen;
import com.cineworld.repos.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ScreenService {

    @Autowired
    private ScreenRepository screenRepository;

    // Create a new screen
    public Screen createScreen(Screen screen) {
        return screenRepository.save(screen);
    }

    // Retrieve a screen by ID
    public Screen getScreenById(Long id) {
        return screenRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid screen ID: " + id));
    }

    // Retrieve all screens
    public List<Screen> getAllScreens() {
        return screenRepository.findAll();
    }

    // Update a screen
    public Screen updateScreen(Long id, Screen screenDetails) {
        Screen screen = screenRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid screen ID: " + id));

        screen.setScreenNumber(screenDetails.getScreenNumber());

        screen.setTheater(screenDetails.getTheater());
        // ... update other fields as necessary

        return screenRepository.save(screen);
    }

    // Delete a screen
    public void deleteScreen(Long id) {
        if (!screenRepository.existsById(id)) {
            throw new IllegalArgumentException("Invalid screen ID: " + id);
        }
        screenRepository.deleteById(id);
    }

    // Additional methods can be added as per your application's requirements.
}

