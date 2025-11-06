package app.adapter.in.validators;

import org.springframework.stereotype.Component;

import app.domain.model.enums.DiagnosticType;

@Component
public class InvoiceDetailValidator {

    public DiagnosticType typeValidator(String type) throws Exception {
        if (type == null || type.trim().isEmpty()) {
            throw new Exception("El tipo de diagnóstico es obligatorio");
        }
        try {
            return DiagnosticType.valueOf(type.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new Exception("Tipo de diagnóstico inválido: " + type);
        }
    }

    public String nameValidator(String name) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("El nombre es obligatorio");
        }
        return name.trim();
    }

    public double costValidator(Double cost) throws Exception {
        if (cost == null || cost < 0) {
            throw new Exception("El costo no puede ser negativo");
        }
        return cost;
    }

    public String doseValidator(String dose) {
        return dose == null ? "" : dose.trim();
    }
}
