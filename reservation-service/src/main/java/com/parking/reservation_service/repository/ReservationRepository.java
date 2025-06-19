package com.parking.reservation_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.parking.reservation_service.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    
   
}
