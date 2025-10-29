package app.domain.services;

import org.springframework.stereotype.Service;

import app.domain.model.EmergencyContact;
import app.domain.ports.EmergencyContactPort;

/**
 * Caso de uso: registrar contactos de emergencia asociados a un paciente.
 */
@Service
public class CreateEmergencyContact {

    private final EmergencyContactPort emergencyContactPort;

    public CreateEmergencyContact(EmergencyContactPort emergencyContactPort) {
        this.emergencyContactPort = emergencyContactPort;
    }

    public void create(EmergencyContact contact) throws Exception {
        if (contact == null) {
            throw new Exception("El contacto de emergencia no puede ser nulo");
        }

        if (contact.getEmergencyContactName() == null || contact.getEmergencyContactName().isEmpty()) {
            throw new Exception("El contacto de emergencia debe tener un nombre válido");
        }

        if (contact.getEmergencyContactPhone() == null || contact.getEmergencyContactPhone().isEmpty()) {
            throw new Exception("El contacto de emergencia debe tener un teléfono válido");
        }

        emergencyContactPort.save(contact);
    }
}
