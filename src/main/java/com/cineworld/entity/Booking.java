package com.cineworld.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "showtime_id", nullable = false)
    private Showtime showtime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_detail_id", referencedColumnName = "paymentDetailId")
    private PaymentDetail paymentDetail;

    private int numberOfSeats;
    private double totalPrice;
    private String status; // Consider using an enum here
    private LocalDateTime bookingTime;
}

