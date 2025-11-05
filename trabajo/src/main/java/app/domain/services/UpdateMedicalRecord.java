package app.domain.services;

import app.domain.model.MedicalRecord;
import app.domain.ports.MedicalRecordPort;
import org.springframework.stereotype.Service;

@Service
public class UpdateMedicalRecord {

    private final MedicalRecordPort medicalRecordPort;

    public UpdateMedicalRecord(MedicalRecordPort medicalRecordPort) {
        this.medicalRecordPort = medicalRecordPort;
    }

    public void update(MedicalRecord medicalRecord) throws Exception {
        if (medicalRecord == null || medicalRecord.getId() == null) {
            throw new Exception("Medical record or its ID cannot be null for update.");
        }
        medicalRecordPort.update(medicalRecord);
    }
}
