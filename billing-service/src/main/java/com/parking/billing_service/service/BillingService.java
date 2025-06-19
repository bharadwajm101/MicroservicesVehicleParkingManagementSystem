package com.parking.billing_service.service;

import com.parking.billing_service.dto.BillingRequest;
import com.parking.billing_service.entity.Invoice;

public interface BillingService {
Invoice calculateInvoice(BillingRequest request);

}
