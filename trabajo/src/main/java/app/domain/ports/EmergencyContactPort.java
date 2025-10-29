package app.domain.ports;

import app.domain.model.EmergencyContact;

/**
 * Puerto del dominio para los contactos de emergencia de los pacientes.
 */
public interface EmergencyContactPort {

    /**
     * Guarda un nuevo contacto de emergencia.
     */
    void save(EmergencyContact contact) throws Exception;

    /**
     * Busca un contacto de emergencia por su nombre o teléfono.
     */
    EmergencyContact findByPhone(String phone) throws Exception;
}
