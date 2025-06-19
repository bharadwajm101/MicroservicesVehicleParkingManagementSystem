package com.parking.parking_slot_service.controller;

import com.parking.parking_slot_service.entity.ParkingSlot;
import com.parking.parking_slot_service.repository.ParkingSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/slots")
public class ParkingSlotController {

    @Autowired
    private ParkingSlotRepository slotRepo;

    
    @PostMapping
    public ParkingSlot createParkingSlot(@RequestBody ParkingSlot slot) {
        return slotRepo.save(slot);
    }
    @GetMapping
    public List<ParkingSlot> getAllSlots() {
        return slotRepo.findAll();
    }
    @PutMapping("/{id}/occupy")
    public ParkingSlot occupySlot(@PathVariable Long id) {
        ParkingSlot slot = slotRepo.findById(id).orElseThrow(() -> new RuntimeException("Slot not found"));
        slot.setOccupied(true);
        return slotRepo.save(slot);
    }
    @PutMapping("/{id}/release")
    public ParkingSlot releaseSlot(@PathVariable Long id) {
        ParkingSlot slot = slotRepo.findById(id).orElseThrow(() -> new RuntimeException("Slot not found"));
        slot.setOccupied(false);
        return slotRepo.save(slot);
    }

}
