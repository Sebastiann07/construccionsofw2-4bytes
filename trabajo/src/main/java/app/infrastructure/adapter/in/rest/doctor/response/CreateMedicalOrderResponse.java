package app.infrastructure.adapter.in.rest.doctor.response;

import app.domain.model.MedicalOrder;

public class CreateMedicalOrderResponse {
    private String orderNumber;
    private String patientId;
    private String doctorUsername;
    private String date;
    private String observations;

    public String getOrderNumber() { return orderNumber; }
    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public String getDoctorUsername() { return doctorUsername; }
    public void setDoctorUsername(String doctorUsername) { this.doctorUsername = doctorUsername; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getObservations() { return observations; }
    public void setObservations(String observations) { this.observations = observations; }

    public static CreateMedicalOrderResponse fromDomain(MedicalOrder o) {
        CreateMedicalOrderResponse r = new CreateMedicalOrderResponse();
        r.setOrderNumber(o.getOrderNumber());
        r.setPatientId(o.getPatientId());
        r.setDoctorUsername(o.getDoctor() == null ? null : o.getDoctor().getUsername());
        r.setDate(o.getDate());
        r.setObservations(o.getObservations());
        return r;
    }
}
