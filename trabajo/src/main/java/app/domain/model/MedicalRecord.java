package app.domain.model;

import java.util.Map;

/**
 * Representa la historia clínica del paciente.
 * Se maneja de forma no estructurada (como documento tipo NoSQL).
 */
public class MedicalRecord {

    private String id;                      // Identificador único del registro
    private String patientId;               // Identificador del paciente
    private Map<String, Object> data;       // Contenido flexible del historial (no estructurado)

    public MedicalRecord() {}

    public MedicalRecord(String id, String patientId, Map<String, Object> data) {
        this.id = id;
        this.patientId = patientId;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
