package com.cineworld.DTO;

import lombok.Data;

@Data
public class PaymentDTO {

    private UserDTO userDTO;
    private PaymentDetailDTO paymentDetailDTO;
}
