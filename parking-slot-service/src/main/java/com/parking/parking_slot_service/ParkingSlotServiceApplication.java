package com.parking.parking_slot_service;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication(scanBasePackages = "com.parking.parking_slot_service")
@EnableDiscoveryClient
public class ParkingSlotServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingSlotServiceApplication.class, args);
	}

}
