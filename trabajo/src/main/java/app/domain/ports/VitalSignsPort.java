package app.domain.ports;

import app.domain.model.VitalSigns;

/**
 * Puerto del dominio para la gestión de signos vitales del paciente.
 */
public interface VitalSignsPort {

    /**
     * Guarda un nuevo registro de signos vitales.
     */
    void save(VitalSigns vitalSigns) throws Exception;

    /**
     * Busca los signos vitales de un paciente específico.
     */
    VitalSigns findByPatientId(long patientId) throws Exception;
}
