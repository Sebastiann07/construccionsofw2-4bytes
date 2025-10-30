package app.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa una visita de enfermería/consulta.
 * Mantiene compatibilidad con listas simples de String pero
 * también permite registrar detalles ricos (InvoiceDetail) para facturación.
 */
public class Visit {

    private String visitId;                     // Identificador único de la visita
    private LocalDateTime visitDate;            // Fecha y hora de la visita
    private Patient patient;                    // Paciente atendido
    private User nurse;                         // Enfermera encargada
    private VitalSigns vitalSigns;              // Signos vitales registrados

    // Mantengo las listas simples que ya tienes (compatibilidad)
    private List<String> medicationsAdministered; // Medicamentos aplicados (nombres)
    private List<String> proceduresPerformed;     // Procedimientos realizados (nombres)
    private List<String> diagnosticTests;         // Ayudas diagnósticas realizadas (nombres)

    // Listas con detalle rico para facturación (opcional)
    private List<InvoiceDetail> medicationDetails;   // Medicamentos con dosis/costo
    private List<InvoiceDetail> procedureDetails;    // Procedimientos con costo

    // Referencia a la orden médica asociada (si aplica)
    private MedicalOrder relatedOrder;

    public Visit() {
        this.medicationsAdministered = new ArrayList<>();
        this.proceduresPerformed = new ArrayList<>();
        this.diagnosticTests = new ArrayList<>();
        this.medicationDetails = new ArrayList<>();
        this.procedureDetails = new ArrayList<>();
        this.visitDate = LocalDateTime.now();
    }

    // === Getters / Setters ===

    public String getVisitId() {
        return visitId;
    }
    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public LocalDateTime getVisitDate() {
        return visitDate;
    }
    public void setVisitDate(LocalDateTime visitDate) {
        this.visitDate = visitDate;
    }

    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public User getNurse() {
        return nurse;
    }
    public void setNurse(User nurse) {
        this.nurse = nurse;
    }

    public VitalSigns getVitalSigns() {
        return vitalSigns;
    }
    public void setVitalSigns(VitalSigns vitalSigns) {
        this.vitalSigns = vitalSigns;
    }

    public List<String> getMedicationsAdministered() {
        return medicationsAdministered;
    }
    public void setMedicationsAdministered(List<String> medicationsAdministered) {
        this.medicationsAdministered = medicationsAdministered;
    }

    public List<String> getProceduresPerformed() {
        return proceduresPerformed;
    }
    public void setProceduresPerformed(List<String> proceduresPerformed) {
        this.proceduresPerformed = proceduresPerformed;
    }

    public List<String> getDiagnosticTests() {
        return diagnosticTests;
    }
    public void setDiagnosticTests(List<String> diagnosticTests) {
        this.diagnosticTests = diagnosticTests;
    }

    public List<InvoiceDetail> getMedicationDetails() {
        return medicationDetails;
    }
    public void setMedicationDetails(List<InvoiceDetail> medicationDetails) {
        this.medicationDetails = medicationDetails;
    }

    public List<InvoiceDetail> getProcedureDetails() {
        return procedureDetails;
    }
    public void setProcedureDetails(List<InvoiceDetail> procedureDetails) {
        this.procedureDetails = procedureDetails;
    }

    public MedicalOrder getRelatedOrder() {
        return relatedOrder;
    }
    public void setRelatedOrder(MedicalOrder relatedOrder) {
        this.relatedOrder = relatedOrder;
    }

    // === Métodos auxiliares para agregar registros ===

    /**
     * Agrega un medicamento como nombre (manteniendo compatibilidad).
     */
    public void addMedicationName(String medicationName) {
        if (this.medicationsAdministered == null) this.medicationsAdministered = new ArrayList<>();
        this.medicationsAdministered.add(medicationName);
    }

    /**
     * Agrega un medicamento con detalle (uso preferible para facturación).
     */
    public void addMedicationDetail(String name, String dose, double cost) {
        if (this.medicationDetails == null) this.medicationDetails = new ArrayList<>();
        InvoiceDetail d = new InvoiceDetail();
        d.setDiagnosticType(app.domain.model.enums.DiagnosticType.MEDICATION);
        d.setName(name);
        d.setDose(dose);
        d.setCost(cost);
        this.medicationDetails.add(d);

        // Mantener nombre simple también (opcional)
        addMedicationName(name);
    }

    /**
     * Agrega un procedimiento por nombre (compatibilidad).
     */
    public void addProcedureName(String procedureName) {
        if (this.proceduresPerformed == null) this.proceduresPerformed = new ArrayList<>();
        this.proceduresPerformed.add(procedureName);
    }

    /**
     * Agrega un procedimiento con detalle (uso preferible para facturación).
     */
    public void addProcedureDetail(String name, double cost) {
        if (this.procedureDetails == null) this.procedureDetails = new ArrayList<>();
        InvoiceDetail d = new InvoiceDetail();
        d.setDiagnosticType(app.domain.model.enums.DiagnosticType.PROCEDURE);
        d.setName(name);
        d.setDose("");
        d.setCost(cost);
        this.procedureDetails.add(d);

        // Mantener nombre simple también (opcional)
        addProcedureName(name);
    }

}
