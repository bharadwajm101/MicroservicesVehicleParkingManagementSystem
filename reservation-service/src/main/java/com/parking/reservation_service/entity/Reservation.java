package com.parking.reservation_service.entity;
import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Table(name = "reservations")
public class Reservation {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;
 
    private Long userId;
 
    private Long slotId;
 
    private String vehicleNumber;
 
    private LocalDateTime startTime;
 
    private LocalDateTime endTime;
 
    private String status;

    public Reservation() {
    }
    public Reservation(Long reservationId, Long userId, Long slotId, String vehicleNumber, LocalDateTime startTime, LocalDateTime endTime, String status) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.slotId = slotId;
        this.vehicleNumber = vehicleNumber;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public Long getReservationId() {
        return reservationId;
    }
    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getSlotId() {
        return slotId;
    }
    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
}


 
 