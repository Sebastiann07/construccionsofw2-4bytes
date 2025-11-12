package app.infrastructure.adapter.in.rest.nurse.response;

import app.domain.model.DiagnosticHelp;

public class RecordDiagnosticHelpResponse {
    private int orderNumber;
    private int itemNumber;
    private String diagnosticId;
    private String diagnosticName;
    private int quantity;
    private double cost;

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

    public static RecordDiagnosticHelpResponse fromDomain(DiagnosticHelp d) {
        RecordDiagnosticHelpResponse r = new RecordDiagnosticHelpResponse();
        r.setOrderNumber(d.getOrderNumber());
        r.setItemNumber(d.getItemNumber());
        r.setDiagnosticId(d.getDiagnosticId());
        r.setDiagnosticName(d.getDiagnosticName());
        r.setQuantity(d.getQuantity());
        r.setCost(d.getCost());
        return r;
    }
}
