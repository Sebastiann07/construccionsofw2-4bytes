package app.domain.ports;

import java.util.Optional;

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
     * Busca un registro médico por el ID del paciente.
     */
    Optional<MedicalRecord> findByPatientId(String patientId) throws Exception;
}
