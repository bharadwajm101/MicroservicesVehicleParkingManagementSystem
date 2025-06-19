package com.parking.billing_service.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.billing_service.repository.InvoiceRepository;

import java.time.Duration;
import java.time.LocalDateTime;


import com.parking.billing_service.dto.BillingRequest;
import com.parking.billing_service.entity.Invoice;
import com.parking.billing_service.service.BillingService;


@Service
public class BillingServiceImpl  implements BillingService {

    @Autowired
    private InvoiceRepository repository;   


    @Override
   public Invoice calculateInvoice(BillingRequest request) {
        // 1. Calculate time difference in hours
        Duration duration = Duration.between(request.getEntryTime(), request.getExitTime());
        long hours = duration.toHours();
        if (duration.toMinutes() % 60 != 0) hours++; // Round up to the next hour
     
        // 2. Pricing logic (you can make it dynamic later)
        double ratePerHour = 50.0;
        double amount = hours * ratePerHour;
     
        // 3. Build and return Invoice
        Invoice invoice = new Invoice();
        invoice.setUserId(request.getUserId());
        invoice.setAmount(amount);
        invoice.setPaymentMethod("CASH"); // default
        invoice.setStatus("UNPAID");
        invoice.setTimestamp(LocalDateTime.now());
     
        // Optional: Save to DB
        return repository.save(invoice);
    }

}
