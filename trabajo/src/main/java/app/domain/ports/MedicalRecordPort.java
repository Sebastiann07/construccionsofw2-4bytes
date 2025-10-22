package app.domain.ports;

import app.domain.model.MedicalRecord;

public interface MedicalRecordPort {
    public void save(MedicalRecord record) throws Exception;
    public MedicalRecord findByPatientId(String patientId) throws Exception;
}
