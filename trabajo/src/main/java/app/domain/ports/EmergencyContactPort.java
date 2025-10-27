package app.domain.ports;

import app.domain.model.EmergencyContact;

/**
* Contrato de persistencia para contactos de emergencia (1 por paciente).
 */
public interface EmergencyContactPort {
    void save(EmergencyContact contact) throws Exception;
}
