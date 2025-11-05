package app.domain.model;

public class Medicine {

    private String medicineId;
    private int orderNumber;         // Número de orden (máximo 6 dígitos)
    private int itemNumber;          // Número del ítem dentro de la orden
    private String medicineName;     // Nombre del medicamento
    private String dose;             // Dosis aplicada
    private String treatmentDuration; // Duración del tratamiento
    private double cost;             // Costo del medicamento

    public Medicine() {}  // Constructor vacío

    // === Getters y Setters ===
    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

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

    public String getMedicineName() {
        return medicineName;
    }
    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
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

    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
}
