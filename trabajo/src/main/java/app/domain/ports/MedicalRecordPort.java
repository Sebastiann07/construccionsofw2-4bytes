package app.domain.ports;

import app.domain.model.MedicalRecord;

/**
 * Puerto del dominio para los registros médicos del paciente.
 */
public interface MedicalRecordPort {

    /**
     * Guarda un nuevo registro médico.
     */
    void save(MedicalRecord record) throws Exception;

    /**
     * Busca el historial médico por ID del paciente o por fecha.
     */
    MedicalRecord findByDate(String date) throws Exception;
}
