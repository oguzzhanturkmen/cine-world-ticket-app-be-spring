package com.cineworld.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "showtimes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showtimeId;

    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)

    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theater_id", nullable = false)

    private Theater theater;

    @ManyToOne
    @JoinColumn(name = "screen_id", nullable = false)

    private Screen screen;

    @OneToMany(mappedBy = "showtime", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Booking> bookings;

    @OneToMany(mappedBy = "showtime", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<SeatReservation> seatReservations;
}

