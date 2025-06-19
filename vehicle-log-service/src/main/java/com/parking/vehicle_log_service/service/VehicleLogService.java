package com.parking.vehicle_log_service.service;
 
import com.parking.vehicle_log_service.entity.VehicleLog;
import com.parking.vehicle_log_service.repository.VehicleLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.time.LocalDateTime;
import java.util.List;
 
@Service
public class VehicleLogService {
 
    @Autowired
    private VehicleLogRepository repository;
 
    public VehicleLog logEntry(VehicleLog log) {
        log.setEntryTime(LocalDateTime.now());
        log.setExitTime(null);
        return repository.save(log);
    }
 
    public VehicleLog logExit(Long id) {
        VehicleLog log = repository.findById(id).orElseThrow();
        log.setExitTime(LocalDateTime.now());
        return repository.save(log);
    }
 
    public List<VehicleLog> getAllLogs() {
        return repository.findAll();
    }
}
 