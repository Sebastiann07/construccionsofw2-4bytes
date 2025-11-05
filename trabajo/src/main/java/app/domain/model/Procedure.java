package app.domain.model;

public class Procedure {

    private int orderNumber;             // Número de orden (máx. 6 dígitos)
    private int itemNumber;              // Número de ítem
    private String procedureId;          // ID del procedimiento (desde inventario)
    private String procedureName;        // Nombre del procedimiento
    private int quantity;                // Número de veces que se repite
    private String frequency;            // Frecuencia con la que se repite
    private double cost;                 // Costo del procedimiento
    private boolean requiresSpecialist;  // Si requiere asistencia de especialista
    private String specialistTypeId;     // ID del tipo de especialidad

    public Procedure() {}  // Constructor vacío (fase 1)

    // === Getters y Setters ===
    public int getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getItemNumber() {
        return itemNumber;
    }
    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getProcedureId() {
        return procedureId;
    }
    public void setProcedureId(String procedureId) {
        this.procedureId = procedureId;
    }

    public String getProcedureName() {
        return procedureName;
    }
    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
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

    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
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
}
