package app.infrastructure.adapter.in.rest.doctor.response;

import app.domain.model.DiagnosticHelp;

public class CreateDiagnosticHelpResponse {
    private int orderNumber;
    private int itemNumber;
    private String diagnosticId;
    private String diagnosticName;
    private int quantity;
    private double cost;
    private boolean requiresSpecialist;
    private String specialistTypeId;

    public int getOrderNumber() { return orderNumber; }
    public void setOrderNumber(int orderNumber) { this.orderNumber = orderNumber; }
    public int getItemNumber() { return itemNumber; }
    public void setItemNumber(int itemNumber) { this.itemNumber = itemNumber; }
    public String getDiagnosticId() { return diagnosticId; }
    public void setDiagnosticId(String diagnosticId) { this.diagnosticId = diagnosticId; }
    public String getDiagnosticName() { return diagnosticName; }
    public void setDiagnosticName(String diagnosticName) { this.diagnosticName = diagnosticName; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
    public boolean isRequiresSpecialist() { return requiresSpecialist; }
    public void setRequiresSpecialist(boolean requiresSpecialist) { this.requiresSpecialist = requiresSpecialist; }
    public String getSpecialistTypeId() { return specialistTypeId; }
    public void setSpecialistTypeId(String specialistTypeId) { this.specialistTypeId = specialistTypeId; }

    public static CreateDiagnosticHelpResponse fromDomain(DiagnosticHelp d) {
        CreateDiagnosticHelpResponse r = new CreateDiagnosticHelpResponse();
        r.setOrderNumber(d.getOrderNumber());
        r.setItemNumber(d.getItemNumber());
        r.setDiagnosticId(d.getDiagnosticId());
        r.setDiagnosticName(d.getDiagnosticName());
        r.setQuantity(d.getQuantity());
        r.setCost(d.getCost());
        r.setRequiresSpecialist(d.isRequiresSpecialist());
        r.setSpecialistTypeId(d.getSpecialistTypeId());
        return r;
    }
}
