package com.example.billing.web;

import com.example.billing.domain.Payment;
import com.example.billing.repository.PaymentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	
		private final PaymentRepository payments;

	public PaymentController(PaymentRepository payments) {
		this.payments = payments;
	}

	@GetMapping
	public List<Payment> getAllPayments() {
		return payments.findAll();
	}

	@GetMapping("/{id}")
	public Payment getPaymentById(@PathVariable Long id) {
		return payments.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
	}

}
