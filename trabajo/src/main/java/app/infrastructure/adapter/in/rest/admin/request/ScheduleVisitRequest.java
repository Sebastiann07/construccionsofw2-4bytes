package app.infrastructure.adapter.in.rest.admin.request;

public class ScheduleVisitRequest {
    private String patientId;
    private String nurseId;
    private String bloodPressure;
    private String temperature;
    private String pulse;
    private String oxygenLevel;

    public ScheduleVisitRequest() {}

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public String getNurseId() { return nurseId; }
    public void setNurseId(String nurseId) { this.nurseId = nurseId; }
    public String getBloodPressure() { return bloodPressure; }
    public void setBloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; }
    public String getTemperature() { return temperature; }
    public void setTemperature(String temperature) { this.temperature = temperature; }
    public String getPulse() { return pulse; }
    public void setPulse(String pulse) { this.pulse = pulse; }
    public String getOxygenLevel() { return oxygenLevel; }
    public void setOxygenLevel(String oxygenLevel) { this.oxygenLevel = oxygenLevel; }
}
