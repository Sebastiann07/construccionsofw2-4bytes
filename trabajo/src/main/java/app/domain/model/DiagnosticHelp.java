package app.domain.model;

public class DiagnosticHelp {

    private int orderNumber;          // Número de orden (máx. 6 dígitos)
    private String diagnosticId;      // Id del examen en el inventario
    private int quantity;             // Cantidad
    private boolean requiresSpecialist; // Si requiere especialista
    private String specialistTypeId;  // Id del tipo de especialista (si aplica)
    private int itemNumber;           // Ítem dentro de la orden

    public DiagnosticHelp() {}

    // === Getters y Setters ===
    public int getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getDiagnosticId() {
        return diagnosticId;
    }
    public void setDiagnosticId(String diagnosticId) {
        this.diagnosticId = diagnosticId;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
