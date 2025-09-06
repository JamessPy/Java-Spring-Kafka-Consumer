package com.example.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.billing.domain.Payment;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByOrderId(Long orderId);
}
