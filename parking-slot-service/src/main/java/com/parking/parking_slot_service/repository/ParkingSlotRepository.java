package com.parking.parking_slot_service.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.parking.parking_slot_service.entity.ParkingSlot;


public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {



}
