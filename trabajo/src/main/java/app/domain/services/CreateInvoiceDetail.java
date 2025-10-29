package app.domain.services;

import org.springframework.stereotype.Service;

import app.domain.model.InvoiceDetail;
import app.domain.ports.InvoiceDetailPort;

/**
 * Caso de uso: registrar detalles de facturación.
 */
@Service
public class CreateInvoiceDetail {

    private final InvoiceDetailPort invoiceDetailPort;

    public CreateInvoiceDetail(InvoiceDetailPort invoiceDetailPort) {
        this.invoiceDetailPort = invoiceDetailPort;
    }

    public void create(InvoiceDetail detail) throws Exception {
        if (detail == null) {
            throw new Exception("El detalle de factura no puede ser nulo");
        }

        if (detail.getName() == null || detail.getName().isEmpty()) {
            throw new Exception("El detalle debe tener un nombre válido");
        }

        if (detail.getCost() <= 0) {
            throw new Exception("El detalle debe tener un costo válido");
        }

        invoiceDetailPort.save(detail);
    }
}
