package app.domain.model;

public class Procedure {

    private int orderNumber;             // Número de orden (máx. 6 dígitos)
    private String procedureId;          // ID del procedimiento (desde inventario)
    private int quantity;                // Cantidad de veces que se realiza
    private String frequency;            // Frecuencia con la que se repite
    private boolean requiresSpecialist;  // Si requiere especialista
    private String specialistTypeId;     // ID del tipo de especialista (si aplica)
    private int itemNumber;              // Ítem de referencia dentro de la orden

    public Procedure() {}  // Constructor vacío (fase 1)

    // === Getters y Setters ===
    public int getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProcedureId() {
        return procedureId;
    }
    public void setProcedureId(String procedureId) {
        this.procedureId = procedureId;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFrequency() {
        return frequency;
    }
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public boolean isRequiresSpecialist() {
        return requiresSpecialist;
    }
    public void setRequiresSpecialist(boolean requiresSpecialist) {
        this.requiresSpecialist = requiresSpecialist;
    }

    public String getSpecialistTypeId() {
        return specialistTypeId;
    }
    public void setSpecialistTypeId(String specialistTypeId) {
        this.specialistTypeId = specialistTypeId;
    }

    public int getItemNumber() {
        return itemNumber;
    }
    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }
}