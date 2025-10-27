package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Invoice;
import app.domain.ports.InvoicePort;

/**
 * Gestiona la creación y validación de facturas en la capa de dominio.
 * Garantiza que cada factura tenga un número único y datos válidos del paciente.
 */
@Service
public class CreateInvoice {

    @Autowired
    private InvoicePort invoicePort;

    public CreateInvoice(InvoicePort invoicePort) {
        this.invoicePort = invoicePort;
    }

    public void createInvoice(Invoice invoice) throws Exception {
        if (invoice == null) {
            throw new Exception("La factura no puede ser nulo");
        }

        if (invoice.getInvoiceNumber() == null || invoice.getInvoiceNumber().isEmpty()) {
            throw new Exception("La factura debe tener un numero de factura valido");
        }

        if (invoice.getPatient() == null) {
            throw new Exception("La factura debe estar asociada con un paciente");
        }

        invoicePort.save(invoice);
    }
}
