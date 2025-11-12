package app.infrastructure.adapter.in.rest.nurse.response;

import app.domain.model.VitalSigns;

public class RecordVitalSignsResponse {
    private String patientId;
    private String bloodPressure;
    private double temperature;
    private int pulse;
    private double oxygenLevel;

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public String getBloodPressure() { return bloodPressure; }
    public void setBloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; }
    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }
    public int getPulse() { return pulse; }
    public void setPulse(int pulse) { this.pulse = pulse; }
    public double getOxygenLevel() { return oxygenLevel; }
    public void setOxygenLevel(double oxygenLevel) { this.oxygenLevel = oxygenLevel; }

    public static RecordVitalSignsResponse fromDomain(String patientId, VitalSigns v) {
        RecordVitalSignsResponse r = new RecordVitalSignsResponse();
        r.setPatientId(patientId);
        r.setBloodPressure(v.getBloodPressure());
        r.setTemperature(v.getTemperature());
        r.setPulse(v.getPulse());
        r.setOxygenLevel(v.getOxygenLevel());
        return r;
    }
}
