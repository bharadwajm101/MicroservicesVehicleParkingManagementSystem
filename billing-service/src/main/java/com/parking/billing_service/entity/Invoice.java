package com.parking.billing_service.entity;
 
import jakarta.persistence.*;
import java.time.LocalDateTime;
 
@Entity
@Table(name = "invoices")
public class Invoice {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;
 
    private Long userId;
 
    private Double amount;
 
    private String paymentMethod; // CASH, UPI, CARD
 
    private String status; // PAID, UNPAID, FAILED
 
    private LocalDateTime timestamp;

    private Long slotId;
 
    // Default constructor
    public Invoice() {
    }
 
    // All-args constructor
    public Invoice(Long invoiceId, Long userId, Long slotId ,Double amount, String paymentMethod, String status, LocalDateTime timestamp) {
        this.invoiceId = invoiceId;
        this.userId = userId;
        this.slotId = slotId;
        if (amount == null || amount < 0) {
            throw new IllegalArgumentException("Amount must be a positive value");
        }
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.timestamp = timestamp;
    }
 
    // Getters and Setters
    public Long getInvoiceId() {
        return invoiceId;
    }
 
    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }
 
    public Long getUserId() {
        return userId;
    }
 
    public void setUserId(Long userId) {
        this.userId = userId;
    }
 
    public Double getAmount() {
        return amount;
    }
 
    public void setAmount(Double amount) {
        this.amount = amount;
    }
 
    public String getPaymentMethod() {
        return paymentMethod;
    }
 
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
 
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
 
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public Long getSlotId() {
        return slotId;
    }
    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }
}
 