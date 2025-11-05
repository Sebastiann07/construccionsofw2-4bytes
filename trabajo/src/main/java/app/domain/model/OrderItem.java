package app.domain.model;

/**
 * Representa un ítem dentro de una orden médica.
 * Puede ser un medicamento, procedimiento o ayuda diagnóstica.
 */
public class OrderItem {

    private String id;             // Identificador único del ítem
    private String itemType;       // Tipo de ítem: "MEDICINE", "PROCEDURE", "DIAGNOSTIC_HELP"
    private String itemName;       // Nombre del ítem (por ejemplo: "Paracetamol", "Radiografía")
    private String description;    // Descripción o detalle adicional
    private int quantity;          // Cantidad o número de aplicaciones
    private double cost;           // Costo individual del ítem
    private double total;          // Costo total (quantity * cost)
    private String status;         // Estado del ítem: "PENDING", "ADMINISTERED", "CANCELLED"
    private String nurseNotes;     // Notas de la enfermera al administrar

    public OrderItem() {}

    // === Getters y Setters ===

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getItemType() {
        return itemType;
    }
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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

    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getNurseNotes() {
        return nurseNotes;
    }
    public void setNurseNotes(String nurseNotes) {
        this.nurseNotes = nurseNotes;
    }

    // === Métodos de apoyo ===
    /**
     * Calcula automáticamente el costo total del ítem.
     */
    public void calculateTotal() {
        this.total = this.cost * this.quantity;
    }
}
