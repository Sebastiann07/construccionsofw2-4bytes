package app.domain.model;

import app.domain.model.enums.Gender;

public class Patient extends Person {
    private Gender gender;
    private EmergencyContact emergencyContact;  // Información de contacto de emergencia (1 solo)
    private Insurance insurance;                // Información del seguro médico (1 solo)

    public Patient() {}

    // Getters / Setters
   
    public EmergencyContact getEmergencyContact() {
        return emergencyContact;
    }
    public void setEmergencyContact(EmergencyContact emergencyContact) {
        this.emergencyContact = emergencyContact;
    
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
}
