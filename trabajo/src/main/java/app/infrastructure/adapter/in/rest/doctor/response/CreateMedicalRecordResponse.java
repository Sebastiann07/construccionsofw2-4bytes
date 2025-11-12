package app.infrastructure.adapter.in.rest.doctor.response;

import app.domain.model.MedicalRecord;

public class CreateMedicalRecordResponse {
    private String id;
    private String patientId;
    private int dataSize;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public int getDataSize() { return dataSize; }
    public void setDataSize(int dataSize) { this.dataSize = dataSize; }

    public static CreateMedicalRecordResponse fromDomain(MedicalRecord r) {
        CreateMedicalRecordResponse resp = new CreateMedicalRecordResponse();
        resp.setId(r.getId());
        resp.setPatientId(r.getPatientId());
        resp.setDataSize(r.getData() == null ? 0 : r.getData().size());
        return resp;
    }
}
