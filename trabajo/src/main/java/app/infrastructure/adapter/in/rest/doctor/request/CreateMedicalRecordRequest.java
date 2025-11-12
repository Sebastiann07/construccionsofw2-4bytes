package app.infrastructure.adapter.in.rest.doctor.request;

import java.util.Map;

public class CreateMedicalRecordRequest {
    private String doctorId;
    private String patientId;
    private Map<String, Object> data;

    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public Map<String, Object> getData() { return data; }
    public void setData(Map<String, Object> data) { this.data = data; }
}
