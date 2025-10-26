package app.domain.model;

public class Medicine {

    private int orderNumber;         // Número de orden (máximo 6 dígitos)
    private String medicineId;         // ID del medicamento (relacionado con el inventario)
    private String dose;             // Dosis aplicada
    private String treatmentDuration; // Duración del tratamiento
    private int itemNumber;          // Número del ítem dentro de la orden

    public Medicine() {}  // Constructor vacío (Fase 1)

    // === Getters y Setters ===
    public int getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    public String getMedicineId() {
        return medicineId;
    }
    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }
    public String getDose() {
        return dose;
    }
    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getTreatmentDuration() {
        return treatmentDuration;
    }
    public void setTreatmentDuration(String treatmentDuration) {
        this.treatmentDuration = treatmentDuration;
    }

    public int getItemNumber() {
        return itemNumber;
    }
    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }
}