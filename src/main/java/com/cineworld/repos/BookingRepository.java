package com.cineworld.repos;

import com.cineworld.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository <Booking , Long> {

}
