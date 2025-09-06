package com.example.billing.messaging;

import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;
import com.example.billing.service.BillingService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component 
public class OrderListener {
	
	private final BillingService billing;
	private final ObjectMapper objectMapper = new ObjectMapper();
	
    public OrderListener(BillingService billing) { this.billing = billing; }

    @KafkaListener(topics = "${billing.topic.orders}", groupId = "${spring.kafka.consumer.group-id}")
    public void onMessage(OrderCreatedEvent evt) {
        billing.process(evt);
        System.out.printf("Billing consumed: id=%d, product=%s, qty=%d%n",
                evt.id(), evt.product(), evt.quantity());
    }
	

}
