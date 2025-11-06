package app.infrastructure.persistence.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "copay_record")
public class CopayRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_id", nullable = false)
    private String patientId;

    @Column(name = "copay_amount", nullable = false)
    private double copayAmount;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public double getCopayAmount() { return copayAmount; }
    public void setCopayAmount(double copayAmount) { this.copayAmount = copayAmount; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}
