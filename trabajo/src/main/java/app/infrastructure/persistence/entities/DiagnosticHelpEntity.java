package app.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "diagnostic_help")
public class DiagnosticHelpEntity {

    @Id
    @Column(name = "diagnostic_id", nullable = false, length = 64)
    private String diagnosticId;

    @Column(name = "order_number")
    private Integer orderNumber;

    @Column(name = "item_number")
    private Integer itemNumber;

    @Column(name = "diagnostic_name")
    private String diagnosticName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "cost")
    private double cost;

    @Column(name = "requires_specialist")
    private boolean requiresSpecialist;

    @Column(name = "specialist_type_id")
    private String specialistTypeId;

    // Getters y Setters
    public String getDiagnosticId() { return diagnosticId; }
    public void setDiagnosticId(String diagnosticId) { this.diagnosticId = diagnosticId; }
    public Integer getOrderNumber() { return orderNumber; }
    public void setOrderNumber(Integer orderNumber) { this.orderNumber = orderNumber; }
    public Integer getItemNumber() { return itemNumber; }
    public void setItemNumber(Integer itemNumber) { this.itemNumber = itemNumber; }
    public String getDiagnosticName() { return diagnosticName; }
    public void setDiagnosticName(String diagnosticName) { this.diagnosticName = diagnosticName; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
    public boolean isRequiresSpecialist() { return requiresSpecialist; }
    public void setRequiresSpecialist(boolean requiresSpecialist) { this.requiresSpecialist = requiresSpecialist; }
    public String getSpecialistTypeId() { return specialistTypeId; }
    public void setSpecialistTypeId(String specialistTypeId) { this.specialistTypeId = specialistTypeId; }
}
