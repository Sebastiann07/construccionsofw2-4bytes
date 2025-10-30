package app.domain.ports;

import app.domain.model.Invoice;

public interface BillingPort {
    Invoice save(Invoice invoice);
}
