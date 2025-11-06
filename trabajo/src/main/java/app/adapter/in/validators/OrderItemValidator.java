package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class OrderItemValidator {

    public String typeValidator(String type) throws Exception {
        if (type == null || type.trim().isEmpty()) {
            throw new Exception("El tipo del ítem es obligatorio");
        }
        return type.trim().toUpperCase();
    }

    public String nameValidator(String name) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("El nombre del ítem es obligatorio");
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

    public String statusValidator(String status) {
        return status == null ? "PENDING" : status.trim().toUpperCase();
    }

    public String text(String value) {
        return value == null ? "" : value.trim();
    }
}
