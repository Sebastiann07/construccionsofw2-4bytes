package app.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice_detail")
public class InvoiceDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "diagnostic_type")
    private String diagnosticType;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private double cost;

    @Column(name = "dose")
    private String dose;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDiagnosticType() { return diagnosticType; }
    public void setDiagnosticType(String diagnosticType) { this.diagnosticType = diagnosticType; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
    public String getDose() { return dose; }
    public void setDose(String dose) { this.dose = dose; }
}
