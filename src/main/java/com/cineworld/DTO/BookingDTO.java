package com.cineworld.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class BookingDTO {


    private Integer totalPrice;
    private Integer userId;
    private Integer paymentDetailId;
    private Integer showTimeId;
    private List<SeatDTO> seats;
}
