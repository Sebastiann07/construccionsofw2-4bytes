package app.infrastructure.adapter.in.rest.doctor.request;

public class PrescribeMedicineRequest {
    private String medicineId;
    private String medicineName;
    private String orderNumber; // numeric expected
    private String itemNumber;  // numeric expected
    private String dose;
    private String treatmentDuration;
    private String cost; // numeric expected

    public String getMedicineId() { return medicineId; }
    public void setMedicineId(String medicineId) { this.medicineId = medicineId; }
    public String getMedicineName() { return medicineName; }
    public void setMedicineName(String medicineName) { this.medicineName = medicineName; }
    public String getOrderNumber() { return orderNumber; }
    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }
    public String getItemNumber() { return itemNumber; }
    public void setItemNumber(String itemNumber) { this.itemNumber = itemNumber; }
    public String getDose() { return dose; }
    public void setDose(String dose) { this.dose = dose; }
    public String getTreatmentDuration() { return treatmentDuration; }
    public void setTreatmentDuration(String treatmentDuration) { this.treatmentDuration = treatmentDuration; }
    public String getCost() { return cost; }
    public void setCost(String cost) { this.cost = cost; }
}
