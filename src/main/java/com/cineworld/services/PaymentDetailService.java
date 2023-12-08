package com.cineworld.services;

import com.cineworld.DTO.PaymentDetailDTO;
import com.cineworld.DTO.PaymentRequest;
import com.cineworld.DTO.PaymentResponse;
import com.cineworld.DTO.UserDTO;
import com.cineworld.entity.Booking;
import com.cineworld.entity.PaymentDetail;
import com.cineworld.entity.User;
import com.cineworld.repos.BookingRepository;
import com.cineworld.repos.PaymentDetailRepository;
import com.cineworld.repos.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentDetailService {

    @Autowired
    private PaymentDetailRepository paymentDetailRepository;
    @Autowired
    private UserRepository userRepository;

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

    public PaymentResponse savePaymentAndUser(PaymentRequest paymentRequest) {
        UserDTO user = paymentRequest.getUser();
        PaymentDetailDTO paymentDetail = paymentRequest.getPaymentDetail();
        User savedUser = new User();
        savedUser.setFullName(user.getFullName());
        savedUser.setEmail(user.getEmail());
        savedUser.setPhoneNumber(user.getPhoneNumber());
        User responseUser = userRepository.save(savedUser);
        PaymentDetail savedPaymentDetail = new PaymentDetail();
        savedPaymentDetail.setCardNumber(paymentDetail.getCardNumber());
        savedPaymentDetail.setCardHolderName(paymentDetail.getCardHolderName());
        LocalDate date = LocalDate.now();
        savedPaymentDetail.setExpirationDate(date);
        savedPaymentDetail.setCvv(paymentDetail.getCvv());
        PaymentDetail responsePayment = paymentDetailRepository.save(savedPaymentDetail);

        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setUserId(Math.toIntExact(responseUser.getUserId()));
        paymentResponse.setPaymentDetailId(Math.toIntExact(responsePayment.getPaymentDetailId()));
        return paymentResponse;


    }

    // Additional methods can be added as per your application's requirements.
}
