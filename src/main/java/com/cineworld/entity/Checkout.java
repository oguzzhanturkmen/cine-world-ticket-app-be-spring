package com.cineworld.entity;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name = "checkout")
public class Checkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "movie_id", nullable = false)
    private Long movieId;

    @Column(name = "number_of_tickets", nullable = false)
    private int numberOfTickets;

    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "checkout_time")
    private Date checkoutTime;
    //private String checkoutTime;




}

