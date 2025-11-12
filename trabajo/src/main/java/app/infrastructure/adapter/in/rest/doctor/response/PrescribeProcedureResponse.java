package app.infrastructure.adapter.in.rest.doctor.response;

import app.domain.model.Procedure;

public class PrescribeProcedureResponse {
    private int orderNumber;
    private int itemNumber;
    private String procedureId;
    private String procedureName;
    private int quantity;
    private String frequency;
    private double cost;
    private boolean requiresSpecialist;
    private String specialistTypeId;

    public int getOrderNumber() { return orderNumber; }
    public void setOrderNumber(int orderNumber) { this.orderNumber = orderNumber; }
    public int getItemNumber() { return itemNumber; }
    public void setItemNumber(int itemNumber) { this.itemNumber = itemNumber; }
    public String getProcedureId() { return procedureId; }
    public void setProcedureId(String procedureId) { this.procedureId = procedureId; }
    public String getProcedureName() { return procedureName; }
    public void setProcedureName(String procedureName) { this.procedureName = procedureName; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getFrequency() { return frequency; }
    public void setFrequency(String frequency) { this.frequency = frequency; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
    public boolean isRequiresSpecialist() { return requiresSpecialist; }
    public void setRequiresSpecialist(boolean requiresSpecialist) { this.requiresSpecialist = requiresSpecialist; }
    public String getSpecialistTypeId() { return specialistTypeId; }
    public void setSpecialistTypeId(String specialistTypeId) { this.specialistTypeId = specialistTypeId; }

    public static PrescribeProcedureResponse fromDomain(Procedure p) {
        PrescribeProcedureResponse r = new PrescribeProcedureResponse();
        r.setOrderNumber(p.getOrderNumber());
        r.setItemNumber(p.getItemNumber());
        r.setProcedureId(p.getProcedureId());
        r.setProcedureName(p.getProcedureName());
        r.setQuantity(p.getQuantity());
        r.setFrequency(p.getFrequency());
        r.setCost(p.getCost());
        r.setRequiresSpecialist(p.isRequiresSpecialist());
        r.setSpecialistTypeId(p.getSpecialistTypeId());
        return r;
    }
}
