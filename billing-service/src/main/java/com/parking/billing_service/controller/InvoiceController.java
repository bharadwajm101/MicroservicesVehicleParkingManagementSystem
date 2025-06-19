package com.parking.billing_service.controller;

 
import com.parking.billing_service.dto.BillingRequest;
import com.parking.billing_service.entity.Invoice;
import com.parking.billing_service.service.BillingService;
import com.parking.billing_service.service.InvoiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
 
import java.util.List;
 
@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
 
    @Autowired
    private InvoiceService service;
    @Autowired
    private BillingService billingService;
 
    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        return ResponseEntity.ok(service.generateInvoice(invoice));
    }
 
    @GetMapping
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        return ResponseEntity.ok(service.getAllInvoices());
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoice(@PathVariable Long id) {
        return ResponseEntity.ok(service.getInvoiceById(id));
    }
    @PostMapping("/calculate")
    public ResponseEntity<Invoice> calculateAndGenerateInvoice(@RequestBody BillingRequest request) {
    Invoice invoice = billingService.calculateInvoice(request);
    return new ResponseEntity<>(invoice, HttpStatus.CREATED);
}
 
}
 