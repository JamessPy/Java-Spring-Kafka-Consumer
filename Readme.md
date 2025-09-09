# Billing-Service

## Overview
Billing-Service is responsible for **handling payments** in an event-driven architecture.

- It **consumes Kafka events** published by Order-Service:
  - `order.created` → triggers payment authorization.
- It **produces new Kafka events** as a result of payment processing:
  - `payment.authorized`
  - `payment.failed`
- In addition, it exposes a minimal **REST API** to:
  - List all payments
  - Retrieve a payment by its ID

This design follows the **event-driven methodology**:
- **Decoupling**: Order-Service and Billing-Service communicate asynchronously via Kafka.
- **Reliability**: At-least-once delivery, idempotent event handling.
- **Extensibility**: Other services (e.g., notification service, reporting service) can subscribe to the same payment events without impacting Billing-Service.

### Runtime
- **Port:** `8082`  
- **Swagger UI:** [http://localhost:8082/swagger-ui.html](http://localhost:8082/swagger-ui.html)  
- **OpenAPI JSON:** [http://localhost:8082/v3/api-docs](http://localhost:8082/v3/api-docs)

---
 
## REST API (OpenAPI Spec)
[OpenAPI](docs/openapi-billing.pretty.json)

