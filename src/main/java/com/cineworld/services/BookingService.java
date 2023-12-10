package com.cineworld.services;

import com.cineworld.DTO.BookingDTO;
import com.cineworld.entity.*;
import com.cineworld.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ShowtimeRepository showtimeRepository;

    @Autowired
    private PaymentDetailRepository paymentDetailRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private SeatReservationRepository seatReservationRepository;

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

    public void saveBooking(BookingDTO booking) {
        PaymentDetail paymentDetail = paymentDetailRepository.findById(Long.valueOf(booking.getPaymentDetailId())).get();
        Showtime showtime = showtimeRepository.findById(Long.valueOf(booking.getShowTimeId())).get();
        User user = userRepository.findById(Long.valueOf(booking.getUserId())).get();
        Booking booking1 = new Booking();
        LocalDate localDate = LocalDate.now();
        booking1.setBookingTime(localDate.atStartOfDay());
        booking1.setNumberOfSeats(booking.getSeats().size());
        booking1.setPaymentDetail(paymentDetail);
        booking1.setShowtime(showtime);

        booking1.setTotalPrice(booking.getTotalPrice());
        booking1.setUser(user);
        bookingRepository.save(booking1);

        booking.getSeats().forEach(s -> {
            Seat seat = seatRepository.findById(s.getSeatId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid seat ID: " + s.getSeatId()));
            SeatReservation seatReservation = new SeatReservation();
            seatReservation.setSeat(seat);
            seatReservation.setShowtime(showtime);


            seatReservationRepository.save(seatReservation);


    }
    );
    }
}



