package app.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "visit")
public class VisitEntity {

    @Id
    @Column(name = "visit_id", nullable = false, length = 64)
    private String visitId;

    @Column(name = "visit_date")
    private String visitDate; // ISO-8601 string para simplicidad

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "nurse_id")
    private Long nurseId;

    @Lob
    @Column(name = "medications_administered", columnDefinition = "LONGTEXT")
    private String medicationsAdministeredJson;

    @Lob
    @Column(name = "procedures_performed", columnDefinition = "LONGTEXT")
    private String proceduresPerformedJson;

    @Lob
    @Column(name = "diagnostic_tests", columnDefinition = "LONGTEXT")
    private String diagnosticTestsJson;

    @Lob
    @Column(name = "medication_details", columnDefinition = "LONGTEXT")
    private String medicationDetailsJson;

    @Lob
    @Column(name = "procedure_details", columnDefinition = "LONGTEXT")
    private String procedureDetailsJson;

    @Column(name = "related_order_number")
    private String relatedOrderNumber;

    // Getters y Setters
    public String getVisitId() { return visitId; }
    public void setVisitId(String visitId) { this.visitId = visitId; }
    public String getVisitDate() { return visitDate; }
    public void setVisitDate(String visitDate) { this.visitDate = visitDate; }
    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
    public Long getNurseId() { return nurseId; }
    public void setNurseId(Long nurseId) { this.nurseId = nurseId; }
    public String getMedicationsAdministeredJson() { return medicationsAdministeredJson; }
    public void setMedicationsAdministeredJson(String medicationsAdministeredJson) { this.medicationsAdministeredJson = medicationsAdministeredJson; }
    public String getProceduresPerformedJson() { return proceduresPerformedJson; }
    public void setProceduresPerformedJson(String proceduresPerformedJson) { this.proceduresPerformedJson = proceduresPerformedJson; }
    public String getDiagnosticTestsJson() { return diagnosticTestsJson; }
    public void setDiagnosticTestsJson(String diagnosticTestsJson) { this.diagnosticTestsJson = diagnosticTestsJson; }
    public String getMedicationDetailsJson() { return medicationDetailsJson; }
    public void setMedicationDetailsJson(String medicationDetailsJson) { this.medicationDetailsJson = medicationDetailsJson; }
    public String getProcedureDetailsJson() { return procedureDetailsJson; }
    public void setProcedureDetailsJson(String procedureDetailsJson) { this.procedureDetailsJson = procedureDetailsJson; }
    public String getRelatedOrderNumber() { return relatedOrderNumber; }
    public void setRelatedOrderNumber(String relatedOrderNumber) { this.relatedOrderNumber = relatedOrderNumber; }
}
