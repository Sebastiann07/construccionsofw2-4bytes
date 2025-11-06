package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class MedicineValidator {

    public String idValidator(String medicineId) throws Exception {
        // Puede ser opcional si se usa name como clave de catálogo; aquí lo exigimos
        if (medicineId == null || medicineId.trim().isEmpty()) {
            throw new Exception("El ID del medicamento es obligatorio");
        }
        return medicineId.trim();
    }

    public String nameValidator(String name) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("El nombre del medicamento es obligatorio");
        }
        return name.trim();
    }

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

    public String doseValidator(String dose) {
        return dose == null ? "" : dose.trim();
    }

    public String treatmentDurationValidator(String duration) {
        return duration == null ? "" : duration.trim();
    }

    public double costValidator(Double cost) throws Exception {
        if (cost == null || cost < 0) {
            throw new Exception("El costo no puede ser negativo");
        }
        return cost;
    }
}
