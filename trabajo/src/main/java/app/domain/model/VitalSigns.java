package app.domain.model;

public class VitalSigns {

    private String bloodPressure;   // Presión arterial (ej. "120/80 mmHg")
    private double temperature;     // Temperatura corporal (°C)
    private int pulse;              // Pulso cardíaco (latidos por minuto)
    private double oxygenLevel;     // Nivel de oxígeno en sangre (% SpO2)

    public VitalSigns() {} // Constructor vacío (Fase 1)

    // === Getters y Setters ===
    public String getBloodPressure() {
        return bloodPressure;
    }
    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getPulse() {
        return pulse;
    }
    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public double getOxygenLevel() {
        return oxygenLevel;
    }
    public void setOxygenLevel(double oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }
}