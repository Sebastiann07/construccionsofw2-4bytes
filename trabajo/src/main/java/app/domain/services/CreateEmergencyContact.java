package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.EmergencyContact;
import app.domain.ports.EmergencyContactPort;

/**
 * Servicio de dominio encargado de crear contactos de emergencia.
 * Realiza validaciones básicas antes de guardar los datos mediante el puerto.
 */
@Service
public class CreateEmergencyContact {

    @Autowired
    private EmergencyContactPort emergencyContactPort;

    public CreateEmergencyContact(EmergencyContactPort emergencyContactPort) {
        this.emergencyContactPort = emergencyContactPort;
    }

    public void createEmergencyContact(EmergencyContact contact) throws Exception {
        // Validación: el objeto no debe ser nulo
        if (contact == null) {
            throw new Exception("El contacto de emergencia no puede ser nulo");
        }

        // Validación: el nombre del contacto es obligatorio
        if (contact.getEmergencyContactName() == null || contact.getEmergencyContactName().isEmpty()) {
            throw new Exception("El contacto de emergencia debe tener un nombre válido");
        }

        // Validación: el número telefónico también es obligatorio
        if (contact.getEmergencyContactPhone() == null || contact.getEmergencyContactPhone().isEmpty()) {
            throw new Exception("El contacto de emergencia debe tener un número telefónico válido");
        }

        // Si pasa todas las validaciones, se guarda mediante el puerto
        emergencyContactPort.save(contact);
    }
}