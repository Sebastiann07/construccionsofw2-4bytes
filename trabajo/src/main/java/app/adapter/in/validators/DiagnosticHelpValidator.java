package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class DiagnosticHelpValidator {

    public int orderNumberValidator(Integer orderNumber) throws Exception {
        if (orderNumber == null || orderNumber <= 0) {
            throw new Exception("El número de orden debe ser mayor a 0");
        }
        if (orderNumber > 999999) {
            throw new Exception("El número de orden no puede exceder 6 dígitos");
        }
        return orderNumber;
    }

    public int itemNumberValidator(Integer itemNumber) throws Exception {
        if (itemNumber == null || itemNumber <= 0) {
            throw new Exception("El número de ítem debe ser mayor a 0");
        }
        return itemNumber;
    }

    public String idValidator(String diagnosticId) {
        return diagnosticId == null ? "" : diagnosticId.trim();
    }

    public String nameValidator(String name) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("El nombre de la ayuda diagnóstica es obligatorio");
        }
        return name.trim();
    }

    public int quantityValidator(Integer quantity) throws Exception {
        if (quantity == null || quantity <= 0) {
            throw new Exception("La cantidad debe ser mayor a 0");
        }
        return quantity;
    }

    public double costValidator(Double cost) throws Exception {
        if (cost == null || cost < 0) {
            throw new Exception("El costo no puede ser negativo");
        }
        return cost;
    }

    public boolean requiresSpecialistValidator(Boolean requires) {
        return requires != null && requires;
    }

    public String specialistTypeValidator(String type, boolean requires) throws Exception {
        if (requires) {
            if (type == null || type.trim().isEmpty()) {
                throw new Exception("Debe indicar el tipo de especialidad requerida");
            }
            return type.trim();
        }
        return type == null ? "" : type.trim();
    }
}
