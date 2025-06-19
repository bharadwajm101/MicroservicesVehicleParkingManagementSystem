package com.parking.reservation_service.controller;
 
import com.parking.reservation_service.entity.Reservation;
import com.parking.reservation_service.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
 
    @Autowired
    private ReservationService service;
 
    @PostMapping
    public ResponseEntity<Reservation> create(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(service.createReservation(reservation));
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> update(@PathVariable Long id, @RequestBody Reservation updated) {
        return ResponseEntity.ok(service.updateReservation(id, updated));
    }
 
    @PutMapping("/{id}/cancel")
    public ResponseEntity<String> cancel(@PathVariable Long id) {
        service.cancelReservation(id);
        return ResponseEntity.ok("Reservation cancelled");
    }
 
    @GetMapping
    public ResponseEntity<List<Reservation>> getAll() {
        return ResponseEntity.ok(service.getAllReservations());
    }
}
 