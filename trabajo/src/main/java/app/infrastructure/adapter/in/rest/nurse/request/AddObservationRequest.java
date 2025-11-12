package app.infrastructure.adapter.in.rest.nurse.request;

import java.util.Map;

public class AddObservationRequest {
    private String id; // medical record id
    private String doctorId; // who adds observation
    private String patientId; // patient id
    private Map<String, Object> data; // updated data map including new observation

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public Map<String, Object> getData() { return data; }
    public void setData(Map<String, Object> data) { this.data = data; }
}
