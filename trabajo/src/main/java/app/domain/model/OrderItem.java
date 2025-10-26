package app.domain.model;

import app.domain.model.enums.ItemType;

public class OrderItem {

    private int itemNumber;         // Número interno del ítem dentro de la orden
    private ItemType type;     // Tipo (MEDICATION, PROCEDURE, EXAM)
    private String referenceId;     // ID del inventario relacionado
    private int quantity;           // Cantidad aplicada
    private String dosage;          // Medicamentos
    private String frequency;       // Procedimientos repetitivos
    private boolean specialistRequired;
    private String specialistType;  // Si aplica

    public OrderItem() {}

    // === Getters / Setters ===
    public int getItemNumber() {
        return itemNumber;
    }
    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public ItemType getType() {
        return type;
    }
    public void setType(ItemType type) {
        this.type = type;
    }

    public String getReferenceId() {
        return referenceId;
    }
    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDosage() {
        return dosage;
    }
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public boolean isSpecialistRequired() {
        return specialistRequired;
    }
    public void setSpecialistRequired(boolean specialistRequired) {
        this.specialistRequired = specialistRequired;
    }

    public String getSpecialistType() {
        return specialistType;
    }
    public void setSpecialistType(String specialistType) {
        this.specialistType = specialistType;
    }
}
