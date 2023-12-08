package com.cineworld.DTO;

import lombok.Data;

@Data
public class PaymentRequest {

        private PaymentDetailDTO paymentDetail;
        private UserDTO user;



}
