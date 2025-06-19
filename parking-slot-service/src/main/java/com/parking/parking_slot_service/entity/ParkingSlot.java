package com.parking.parking_slot_service.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "parking_slots")
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slotId;

    private String type;
    private boolean isOccupied;
    private String location;
    
    public ParkingSlot() {
    }
    public ParkingSlot(Long slotId, String type, boolean isOccupied, String location) {
        this.slotId = slotId;
        this.type = type;
        this.isOccupied = isOccupied;
        this.location = location;
    }

    public Long getSlotId() {
        return slotId;
    }
    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public boolean isOccupied() {
        return isOccupied;
    }
    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
