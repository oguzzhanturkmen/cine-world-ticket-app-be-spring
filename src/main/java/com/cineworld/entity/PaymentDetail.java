package com.cineworld.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "payment_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentDetailId;

    private String cardNumber;
    private LocalDate expirationDate;
    private String cardHolderName;
    private String cvv;

    @OneToOne(mappedBy = "paymentDetail")
    private Booking booking;
}

