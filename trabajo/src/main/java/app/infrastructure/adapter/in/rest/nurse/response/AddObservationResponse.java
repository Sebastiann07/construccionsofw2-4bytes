package app.infrastructure.adapter.in.rest.nurse.response;

import app.domain.model.MedicalRecord;

public class AddObservationResponse {
    private String id;
    private String patientId;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public static AddObservationResponse fromDomain(MedicalRecord r) {
        AddObservationResponse resp = new AddObservationResponse();
        resp.setId(r.getId());
        resp.setPatientId(r.getPatientId());
        return resp;
    }
}
