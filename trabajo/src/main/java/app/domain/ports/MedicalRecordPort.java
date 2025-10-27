package app.domain.ports;

import app.domain.model.MedicalRecord;

/**
 * Define operaciones de persistencia para registros médicos 
 */
public interface MedicalRecordPort {
    void save(MedicalRecord record) throws Exception;
    MedicalRecord findByPatientId(long patientId) throws Exception;
}
