package app.domain.ports;

import app.domain.model.InvoiceDetail;

public interface InvoiceDetailPort {
    public void save(InvoiceDetail detail) throws Exception;
}
