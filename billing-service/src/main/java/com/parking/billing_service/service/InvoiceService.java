package com.parking.billing_service.service;

 
import com.parking.billing_service.entity.Invoice;
import com.parking.billing_service.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import java.time.LocalDateTime;
import java.util.List;
 
@Service
public class InvoiceService {
 
    @Autowired
    private InvoiceRepository repository;
 
    public Invoice generateInvoice(Invoice invoice) {
        invoice.setStatus("PAID");
        invoice.setTimestamp(LocalDateTime.now());
        return repository.save(invoice);
    }
 
    public List<Invoice> getAllInvoices() {
        return repository.findAll();
    }
 
    public Invoice getInvoiceById(Long id) {
        return repository.findById(id).orElseThrow();
    }

 
}
 

 
