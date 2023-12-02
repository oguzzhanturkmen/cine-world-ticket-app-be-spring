package com.cineworld.services;

import com.cineworld.entity.Booking;
import com.cineworld.entity.PaymentDetail;
import com.cineworld.repos.BookingRepository;
import com.cineworld.repos.PaymentDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class PaymentDetailService {

    @Autowired
    private PaymentDetailRepository paymentDetailRepository;

    // Create a new payment detail
    public PaymentDetail createPaymentDetail(PaymentDetail paymentDetail) {
        return paymentDetailRepository.save(paymentDetail);
    }

    // Retrieve a payment detail by ID
    public PaymentDetail getPaymentDetailById(Long id) {
        return paymentDetailRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid payment detail ID: " + id));
    }

    // Retrieve all payment details
    public List<PaymentDetail> getAllPaymentDetails() {
        return paymentDetailRepository.findAll();
    }

    // Update a payment detail
    public PaymentDetail updatePaymentDetail(Long id, PaymentDetail paymentDetailDetails) {
        PaymentDetail paymentDetail = paymentDetailRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid payment detail ID: " + id));

        paymentDetail.setCardNumber(paymentDetailDetails.getCardNumber());
        paymentDetail.setExpirationDate(paymentDetailDetails.getExpirationDate());
        paymentDetail.setCardHolderName(paymentDetailDetails.getCardHolderName());
        paymentDetail.setCvv(paymentDetailDetails.getCvv());
        // ... update other fields as necessary

        return paymentDetailRepository.save(paymentDetail);
    }

    // Delete a payment detail
    public void deletePaymentDetail(Long id) {
        if (!paymentDetailRepository.existsById(id)) {
            throw new IllegalArgumentException("Invalid payment detail ID: " + id);
        }
        paymentDetailRepository.deleteById(id);
    }

    // Additional methods can be added as per your application's requirements.
}
