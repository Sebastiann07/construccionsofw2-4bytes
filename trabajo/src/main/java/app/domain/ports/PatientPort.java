package app.domain.ports;

import app.domain.model.Patient;

/**
 * Puerto del dominio para la gestión de pacientes.
 */
public interface PatientPort {

    /**
     * Guarda un nuevo paciente.
     */
    void save(Patient patient) throws Exception;

    /**
     * Busca un paciente por su ID.
     */
    Patient findById(long id) throws Exception;

}
