package com.example.billing.service;

import com.example.billing.domain.Payment;
import com.example.billing.messaging.OrderCreatedEvent;
import com.example.billing.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BillingService {

    private final PaymentRepository payments;

    public BillingService(PaymentRepository payments) {
        this.payments = payments;
    }

    @Transactional
    public void process(OrderCreatedEvent evt) {
        // Idempotent: do not create a payment if one already exists for this order
        if (payments.findByOrderId(evt.id()).isPresent()) {
            return;
        }
        payments.save(new Payment(evt.id(), "CREATED"));
    }
}
