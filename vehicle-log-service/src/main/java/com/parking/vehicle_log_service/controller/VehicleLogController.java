package com.parking.vehicle_log_service.controller;
 
import com.parking.vehicle_log_service.entity.VehicleLog;
import com.parking.vehicle_log_service.service.VehicleLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
@RequestMapping("/api/vehicle-log")
public class VehicleLogController {
 
    @Autowired
    private VehicleLogService service;
 
    @PostMapping("/entry")
    public ResponseEntity<VehicleLog> logEntry(@RequestBody VehicleLog log) {
        return ResponseEntity.ok(service.logEntry(log));
    }
 
    @PutMapping("/exit/{id}")
    public ResponseEntity<VehicleLog> logExit(@PathVariable Long id) {
        return ResponseEntity.ok(service.logExit(id));
    }
 
    @GetMapping
    public ResponseEntity<List<VehicleLog>> getAllLogs() {
        return ResponseEntity.ok(service.getAllLogs());
    }
}
 