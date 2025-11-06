package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class InvoiceValidator {

    public String invoiceNumberValidator(String invoiceNumber) {
        // La factura puede generarse automáticamente si es null/empty
        return invoiceNumber == null ? "" : invoiceNumber.trim();
    }

    public double nonNegativeAmount(Double amount, String field) throws Exception {
        if (amount == null || amount < 0) {
            throw new Exception(field + " no puede ser negativo");
        }
        return amount;
    }
}
