package app.infrastructure.adapter.in.rest.admin.response;

public class ScheduleVisitResponse {
    private String visitId;
    private long patientId;
    private long nurseId; // cambiado de nurseUsername a nurseId
    private String bloodPressure;
    private double temperature;
    private int pulse;
    private double oxygenLevel;
    private String visitDate;

    public String getVisitId() { return visitId; }
    public void setVisitId(String visitId) { this.visitId = visitId; }
    public long getPatientId() { return patientId; }
    public void setPatientId(long patientId) { this.patientId = patientId; }
    public long getNurseId() { return nurseId; }
    public void setNurseId(long nurseId) { this.nurseId = nurseId; }
    public String getBloodPressure() { return bloodPressure; }
    public void setBloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; }
    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }
    public int getPulse() { return pulse; }
    public void setPulse(int pulse) { this.pulse = pulse; }
    public double getOxygenLevel() { return oxygenLevel; }
    public void setOxygenLevel(double oxygenLevel) { this.oxygenLevel = oxygenLevel; }
    public String getVisitDate() { return visitDate; }
    public void setVisitDate(String visitDate) { this.visitDate = visitDate; }
}
