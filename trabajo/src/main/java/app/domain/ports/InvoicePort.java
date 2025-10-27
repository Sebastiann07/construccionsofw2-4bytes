package app.domain.ports;

import app.domain.model.Invoice;

/**
 * Define operaciones de persistencia para facturas.
 */
public interface InvoicePort {
    void save(Invoice invoice) throws Exception;
}
