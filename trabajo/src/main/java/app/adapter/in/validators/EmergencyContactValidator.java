package app.adapter.in.validators;

import org.springframework.stereotype.Component;

import app.domain.model.EmergencyContact;

@Component
public class EmergencyContactValidator {

    public void validate(EmergencyContact c) throws Exception {
        if (c == null) {
            throw new Exception("El contacto de emergencia no puede ser nulo");
        }
        if (c.getEmergencyContactName() == null || c.getEmergencyContactName().trim().isEmpty()) {
            throw new Exception("El nombre del contacto de emergencia es obligatorio");
        }
        if (c.getEmergencyContactPhone() == null || c.getEmergencyContactPhone().trim().isEmpty()) {
            throw new Exception("El teléfono del contacto de emergencia es obligatorio");
        }
        if (c.getEmergencyContactRelation() == null || c.getEmergencyContactRelation().trim().isEmpty()) {
            throw new Exception("La relación del contacto de emergencia es obligatoria");
        }
    }
}
