package app.infrastructure.adapter.in.rest.doctor.response;

import app.domain.model.Medicine;

public class PrescribeMedicineResponse {
    private String medicineId;
    private String medicineName;
    private int orderNumber;
    private int itemNumber;
    private String dose;
    private String treatmentDuration;
    private double cost;

    public String getMedicineId() { return medicineId; }
    public void setMedicineId(String medicineId) { this.medicineId = medicineId; }
    public String getMedicineName() { return medicineName; }
    public void setMedicineName(String medicineName) { this.medicineName = medicineName; }
    public int getOrderNumber() { return orderNumber; }
    public void setOrderNumber(int orderNumber) { this.orderNumber = orderNumber; }
    public int getItemNumber() { return itemNumber; }
    public void setItemNumber(int itemNumber) { this.itemNumber = itemNumber; }
    public String getDose() { return dose; }
    public void setDose(String dose) { this.dose = dose; }
    public String getTreatmentDuration() { return treatmentDuration; }
    public void setTreatmentDuration(String treatmentDuration) { this.treatmentDuration = treatmentDuration; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }

    public static PrescribeMedicineResponse fromDomain(Medicine m) {
        PrescribeMedicineResponse r = new PrescribeMedicineResponse();
        r.setMedicineId(m.getMedicineId());
        r.setMedicineName(m.getMedicineName());
        r.setOrderNumber(m.getOrderNumber());
        r.setItemNumber(m.getItemNumber());
        r.setDose(m.getDose());
        r.setTreatmentDuration(m.getTreatmentDuration());
        r.setCost(m.getCost());
        return r;
    }
}
