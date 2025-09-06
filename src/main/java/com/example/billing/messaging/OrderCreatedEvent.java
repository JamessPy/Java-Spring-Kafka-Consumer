package com.example.billing.messaging;

public record OrderCreatedEvent(Long id, String product, Integer quantity) {}
