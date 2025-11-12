package app.infrastructure.adapter.in.rest.doctor.request;

public class CreateMedicalOrderRequest {
    private String doctorId;
    private String patientId;
    private String date;
    private String observations;

    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getObservations() { return observations; }
    public void setObservations(String observations) { this.observations = observations; }
}
