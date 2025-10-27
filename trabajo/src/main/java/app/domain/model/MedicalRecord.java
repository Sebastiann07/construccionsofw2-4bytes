package app.domain.model;

/**
 * Representa la historia clínica de un paciente.
 * Cada registro se asocia a un paciente y a un médico responsable.
 */
public class MedicalRecord {

    private String patientId;           // Cédula o ID del paciente (clave principal del paciente)
    private String date;                // Fecha de atención
    private String doctorId;            // Cédula del médico que atendió
    private String reasonForVisit;      // Motivo de la consulta
    private String symptoms;            // Sintomatología
    private String diagnosis;           // Diagnóstico final

    public MedicalRecord() {}

    // === Getters y Setters ===
    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

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
