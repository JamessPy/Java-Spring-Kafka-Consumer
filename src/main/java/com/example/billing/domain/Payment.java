package com.example.billing.domain;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "payments", uniqueConstraints = {
        @UniqueConstraint(name = "uk_payments_order_id", columnNames = "orderId")
})
public class Payment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;

    private String status; // CREATED, AUTHORIZED, FAILED ...

    private Instant createdAt = Instant.now();

    public Payment() {}

    public Payment(Long orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    // getters & setters
    public Long getId() { return id; }
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
