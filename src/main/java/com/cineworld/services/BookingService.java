package com.cineworld.services;

import com.cineworld.entity.Booking;
import com.cineworld.entity.Showtime;
import com.cineworld.repos.BookingRepository;
import com.cineworld.repos.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ShowtimeRepository showtimeRepository;

    // Create a new booking
    public Booking createBooking(Booking booking) {
        // Validate if the showtime exists and if the seats are available
        Optional<Showtime> showtime = showtimeRepository.findById(booking.getShowtime().getShowtimeId());
        if (showtime.isPresent() && areSeatsAvailable(showtime.get(), booking.getNumberOfSeats())) {
            booking.setStatus("reserved"); // Initial status
            return bookingRepository.save(booking);
        }
        throw new IllegalStateException("Showtime not available or seats not available");
    }

    // Check if the required number of seats are available
    private boolean areSeatsAvailable(Showtime showtime, int numberOfSeats) {
        // Implement logic to check if the requested number of seats are available
        // This can be a simple count check or a more complex seat allocation check
        return true; // For simplicity, returning true here
    }

    // Retrieve a booking by ID
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid booking ID: " + id));
    }

    // Retrieve all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Update a booking
    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid booking ID: " + id));
        // Update the necessary fields, like numberOfSeats, status, etc.
        booking.setNumberOfSeats(bookingDetails.getNumberOfSeats());
        booking.setStatus(bookingDetails.getStatus());
        // ... update other fields as necessary
        return bookingRepository.save(booking);
    }

    // Cancel (or delete) a booking
    public void deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid booking ID: " + id));
        booking.setStatus("cancelled"); // Mark as cancelled instead of deleting
        bookingRepository.save(booking);
    }

    // Additional methods can be added as per your application's requirements.
}



