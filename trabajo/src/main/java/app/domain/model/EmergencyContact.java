package app.domain.model;

public class EmergencyContact {

    private String emergencyContactName;     // Nombre del contacto de emergencia
    private String emergencyContactPhone;    // Teléfono del contacto de emergencia
    private String emergencyContactRelation;  // Relación con el paciente (madre, padre, amigo, etc.)

    public EmergencyContact() {}  // Constructor vacío (coherente con la fase actual)

    // === Getters y Setters ===
    public String getEmergencyContactRelation() {
        return emergencyContactRelation;
    }

    public void setEmergencyContactRelation(String emergencyContactRelation) {
        this.emergencyContactRelation = emergencyContactRelation;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }
    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }
    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

}