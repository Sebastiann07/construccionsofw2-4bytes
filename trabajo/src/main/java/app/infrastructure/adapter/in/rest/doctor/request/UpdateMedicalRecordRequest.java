package app.infrastructure.adapter.in.rest.doctor.request;

import java.util.Map;

public class UpdateMedicalRecordRequest {
    private String id; // existing medical record id
    private String doctorId;
    private String patientId;
    private Map<String, Object> data; // new/merged data

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public Map<String, Object> getData() { return data; }
    public void setData(Map<String, Object> data) { this.data = data; }
}
