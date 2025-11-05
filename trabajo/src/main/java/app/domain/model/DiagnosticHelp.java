package app.domain.model;

public class DiagnosticHelp {

    private int orderNumber;              // Número de orden (máx. 6 dígitos)
    private int itemNumber;               // Número de ítem
    private String diagnosticId;          // ID de la ayuda diagnóstica (desde inventario)
    private String diagnosticName;        // Nombre de la ayuda diagnóstica
    private int quantity;                 // Cantidad
    private double cost;                  // Costo
    private boolean requiresSpecialist;   // Si requiere especialista
    private String specialistTypeId;      // ID del tipo de especialidad (si aplica)

    public DiagnosticHelp() {}

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

    public String getDiagnosticId() {
        return diagnosticId;
    }
    public void setDiagnosticId(String diagnosticId) {
        this.diagnosticId = diagnosticId;
    }

    public String getDiagnosticName() {
        return diagnosticName;
    }
    public void setDiagnosticName(String diagnosticName) {
        this.diagnosticName = diagnosticName;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
