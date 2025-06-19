package com.parking.vehicle_log_service.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.parking.vehicle_log_service.entity.VehicleLog;
public interface VehicleLogRepository extends JpaRepository<VehicleLog, Long> {
    // Additional query methods can be defined here if needed

}
