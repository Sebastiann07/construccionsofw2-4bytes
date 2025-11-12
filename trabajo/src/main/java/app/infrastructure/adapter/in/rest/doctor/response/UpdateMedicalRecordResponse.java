package app.infrastructure.adapter.in.rest.doctor.response;

import app.domain.model.MedicalRecord;

public class UpdateMedicalRecordResponse {
    private String id;
    private String patientId;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public static UpdateMedicalRecordResponse fromDomain(MedicalRecord r) {
        UpdateMedicalRecordResponse resp = new UpdateMedicalRecordResponse();
        resp.setId(r.getId());
        resp.setPatientId(r.getPatientId());
        return resp;
    }
}
