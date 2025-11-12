package app.infrastructure.adapter.in.rest.nurse.request;

public class RecordVitalSignsRequest {
    private String patientId; // numeric expected
    private String bloodPressure;
    private String temperature; // numeric
    private String pulse;       // numeric
    private String oxygenLevel; // numeric

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public String getBloodPressure() { return bloodPressure; }
    public void setBloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; }
    public String getTemperature() { return temperature; }
    public void setTemperature(String temperature) { this.temperature = temperature; }
    public String getPulse() { return pulse; }
    public void setPulse(String pulse) { this.pulse = pulse; }
    public String getOxygenLevel() { return oxygenLevel; }
    public void setOxygenLevel(String oxygenLevel) { this.oxygenLevel = oxygenLevel; }
}
