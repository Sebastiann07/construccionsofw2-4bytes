package app.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medical_procedure")
public class ProcedureEntity {

    @Id
    @Column(name = "procedure_id", nullable = false, length = 64)
    private String procedureId;

    @Column(name = "order_number")
    private Integer orderNumber;

    @Column(name = "item_number")
    private Integer itemNumber;

    @Column(name = "procedure_name")
    private String procedureName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "frequency")
    private String frequency;

    @Column(name = "cost")
    private double cost;

    @Column(name = "requires_specialist")
    private boolean requiresSpecialist;

    @Column(name = "specialist_type_id")
    private String specialistTypeId;

    // Getters y Setters
    public String getProcedureId() { return procedureId; }
    public void setProcedureId(String procedureId) { this.procedureId = procedureId; }
    public Integer getOrderNumber() { return orderNumber; }
    public void setOrderNumber(Integer orderNumber) { this.orderNumber = orderNumber; }
    public Integer getItemNumber() { return itemNumber; }
    public void setItemNumber(Integer itemNumber) { this.itemNumber = itemNumber; }
    public String getProcedureName() { return procedureName; }
    public void setProcedureName(String procedureName) { this.procedureName = procedureName; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public String getFrequency() { return frequency; }
    public void setFrequency(String frequency) { this.frequency = frequency; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
    public boolean isRequiresSpecialist() { return requiresSpecialist; }
    public void setRequiresSpecialist(boolean requiresSpecialist) { this.requiresSpecialist = requiresSpecialist; }
    public String getSpecialistTypeId() { return specialistTypeId; }
    public void setSpecialistTypeId(String specialistTypeId) { this.specialistTypeId = specialistTypeId; }
}
