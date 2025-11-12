package app.infrastructure.adapter.in.rest.doctor.request;

public class CreateDiagnosticHelpRequest {
    private String orderNumber; // numeric expected
    private String itemNumber;  // numeric expected
    private String diagnosticId;
    private String diagnosticName;
    private String quantity; // numeric expected
    private String cost; // numeric expected
    private String requiresSpecialist; // boolean expected
    private String specialistTypeId; // optional

    public String getOrderNumber() { return orderNumber; }
    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }
    public String getItemNumber() { return itemNumber; }
    public void setItemNumber(String itemNumber) { this.itemNumber = itemNumber; }
    public String getDiagnosticId() { return diagnosticId; }
    public void setDiagnosticId(String diagnosticId) { this.diagnosticId = diagnosticId; }
    public String getDiagnosticName() { return diagnosticName; }
    public void setDiagnosticName(String diagnosticName) { this.diagnosticName = diagnosticName; }
    public String getQuantity() { return quantity; }
    public void setQuantity(String quantity) { this.quantity = quantity; }
    public String getCost() { return cost; }
    public void setCost(String cost) { this.cost = cost; }
    public String getRequiresSpecialist() { return requiresSpecialist; }
    public void setRequiresSpecialist(String requiresSpecialist) { this.requiresSpecialist = requiresSpecialist; }
    public String getSpecialistTypeId() { return specialistTypeId; }
    public void setSpecialistTypeId(String specialistTypeId) { this.specialistTypeId = specialistTypeId; }
}
