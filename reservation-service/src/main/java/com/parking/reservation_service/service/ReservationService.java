package com.parking.reservation_service.service;
 
import com.parking.reservation_service.entity.Reservation;
import com.parking.reservation_service.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service
public class ReservationService {
 
    @Autowired
    private ReservationRepository repository;
 
    public Reservation createReservation(Reservation reservation) {
        reservation.setStatus("ACTIVE");
        return repository.save(reservation);
    }
 
    public Reservation updateReservation(Long id, Reservation updated) {
        Reservation reservation = repository.findById(id).orElseThrow();
        reservation.setStartTime(updated.getStartTime());
        reservation.setEndTime(updated.getEndTime());
        reservation.setStatus(updated.getStatus());
        return repository.save(reservation);
    }
 
    public void cancelReservation(Long id) {
        Reservation reservation = repository.findById(id).orElseThrow();
        reservation.setStatus("CANCELLED");
        repository.save(reservation);
    }
 
    public List<Reservation> getAllReservations() {
        return repository.findAll();
    }
}
 