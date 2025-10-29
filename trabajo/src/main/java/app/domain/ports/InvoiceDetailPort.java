package app.domain.ports;

import app.domain.model.InvoiceDetail;

public interface InvoiceDetailPort {
    void save(InvoiceDetail invoiceDetail) throws Exception;
}
