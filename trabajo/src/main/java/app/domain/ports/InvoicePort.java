package app.domain.ports;

import app.domain.model.Invoice;

/**
 * Puerto del dominio para las facturas del sistema clínico.
 */
public interface InvoicePort {

    /**
     * Guarda una nueva factura.
     */
    void save(Invoice invoice) throws Exception;

    /**
     * Busca una factura por número o ID.
     */
    Invoice findById(String id) throws Exception;
}
