package app.domain.model;

public class MedicalRecord {

    private String date;                // Fecha de atención (clave del registro)
    private String doctorId;            // Cédula del médico que atendió (máx. 10 dígitos)
    private String reasonForVisit;      // Motivo de la consulta
    private String symptoms;            // Sintomatología
    private String diagnosis;           // Diagnóstico final

    public MedicalRecord() {}  // Constructor vacío (Fase 1)

    // === Getters y Setters ===
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getReasonForVisit() {
        return reasonForVisit;
    }
    public void setReasonForVisit(String reasonForVisit) {
        this.reasonForVisit = reasonForVisit;
    }

    public String getSymptoms() {
        return symptoms;
    }
    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}