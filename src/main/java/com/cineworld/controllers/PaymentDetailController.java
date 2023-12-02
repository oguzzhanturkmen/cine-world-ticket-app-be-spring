package com.cineworld.controllers;

import com.cineworld.entity.PaymentDetail;
import com.cineworld.services.PaymentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/payment-details")
public class PaymentDetailController {

    @Autowired
    private PaymentDetailService paymentDetailService;

    // Create a new payment detail
    @PostMapping("/")
    public ResponseEntity<PaymentDetail> createPaymentDetail(@RequestBody PaymentDetail paymentDetail) {
        PaymentDetail newPaymentDetail = paymentDetailService.createPaymentDetail(paymentDetail);
        return ResponseEntity.ok(newPaymentDetail);
    }

    // Get a single payment detail by ID
    @GetMapping("/{id}")
    public ResponseEntity<PaymentDetail> getPaymentDetailById(@PathVariable Long id) {
        PaymentDetail paymentDetail = paymentDetailService.getPaymentDetailById(id);
        if (paymentDetail == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paymentDetail);
    }

    // Get all payment details
    @GetMapping("/")
    public List<PaymentDetail> getAllPaymentDetails() {
        return paymentDetailService.getAllPaymentDetails();
    }

    // Update a payment detail
    @PutMapping("/{id}")
    public ResponseEntity<PaymentDetail> updatePaymentDetail(@PathVariable Long id, @RequestBody PaymentDetail paymentDetailDetails) {
        try {
            PaymentDetail updatedPaymentDetail = paymentDetailService.updatePaymentDetail(id, paymentDetailDetails);
            return ResponseEntity.ok(updatedPaymentDetail);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a payment detail
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentDetail(@PathVariable Long id) {
        try {
            paymentDetailService.deletePaymentDetail(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

