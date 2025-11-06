package app.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicine")
public class MedicineEntity {

    @Id
    @Column(name = "medicine_id", nullable = false, length = 64)
    private String medicineId;

    @Column(name = "order_number")
    private Integer orderNumber;

    @Column(name = "item_number")
    private Integer itemNumber;

    @Column(name = "medicine_name")
    private String medicineName;

    @Column(name = "dose")
    private String dose;

    @Column(name = "treatment_duration")
    private String treatmentDuration;

    @Column(name = "cost")
    private double cost;

    // Getters y Setters
    public String getMedicineId() { return medicineId; }
    public void setMedicineId(String medicineId) { this.medicineId = medicineId; }
    public Integer getOrderNumber() { return orderNumber; }
    public void setOrderNumber(Integer orderNumber) { this.orderNumber = orderNumber; }
    public Integer getItemNumber() { return itemNumber; }
    public void setItemNumber(Integer itemNumber) { this.itemNumber = itemNumber; }
    public String getMedicineName() { return medicineName; }
    public void setMedicineName(String medicineName) { this.medicineName = medicineName; }
    public String getDose() { return dose; }
    public void setDose(String dose) { this.dose = dose; }
    public String getTreatmentDuration() { return treatmentDuration; }
    public void setTreatmentDuration(String treatmentDuration) { this.treatmentDuration = treatmentDuration; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
}
