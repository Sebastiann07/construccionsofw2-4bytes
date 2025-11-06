package app.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vital_signs")
public class VitalSignsEntity {

    @Id
    @Column(name = "patient_id")
    private Long patientId; // 1 registro por paciente

    @Column(name = "blood_pressure")
    private String bloodPressure;

    @Column(name = "temperature")
    private double temperature;

    @Column(name = "pulse")
    private int pulse;

    @Column(name = "oxygen_level")
    private double oxygenLevel;

    // Getters y Setters
    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
    public String getBloodPressure() { return bloodPressure; }
    public void setBloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; }
    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }
    public int getPulse() { return pulse; }
    public void setPulse(int pulse) { this.pulse = pulse; }
    public double getOxygenLevel() { return oxygenLevel; }
    public void setOxygenLevel(double oxygenLevel) { this.oxygenLevel = oxygenLevel; }
}
