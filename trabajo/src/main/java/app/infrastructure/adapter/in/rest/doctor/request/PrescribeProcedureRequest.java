package app.infrastructure.adapter.in.rest.doctor.request;

public class PrescribeProcedureRequest {
    private String orderNumber; // numeric expected
    private String itemNumber;  // numeric expected
    private String procedureId;
    private String procedureName;
    private String quantity; // numeric expected
    private String frequency;
    private String cost; // numeric expected
    private String requiresSpecialist; // boolean expected
    private String specialistTypeId; // optional

    public String getOrderNumber() { return orderNumber; }
    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }
    public String getItemNumber() { return itemNumber; }
    public void setItemNumber(String itemNumber) { this.itemNumber = itemNumber; }
    public String getProcedureId() { return procedureId; }
    public void setProcedureId(String procedureId) { this.procedureId = procedureId; }
    public String getProcedureName() { return procedureName; }
    public void setProcedureName(String procedureName) { this.procedureName = procedureName; }
    public String getQuantity() { return quantity; }
    public void setQuantity(String quantity) { this.quantity = quantity; }
    public String getFrequency() { return frequency; }
    public void setFrequency(String frequency) { this.frequency = frequency; }
    public String getCost() { return cost; }
    public void setCost(String cost) { this.cost = cost; }
    public String getRequiresSpecialist() { return requiresSpecialist; }
    public void setRequiresSpecialist(String requiresSpecialist) { this.requiresSpecialist = requiresSpecialist; }
    public String getSpecialistTypeId() { return specialistTypeId; }
    public void setSpecialistTypeId(String specialistTypeId) { this.specialistTypeId = specialistTypeId; }
}
