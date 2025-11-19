package app.domain.services;

import app.domain.model.MedicalRecord;
import app.domain.ports.MedicalRecordPort;
import org.springframework.stereotype.Service;
import app.application.exceptions.NotFoundException;

@Service
public class UpdateMedicalRecord {

    private final MedicalRecordPort medicalRecordPort;

    public UpdateMedicalRecord(MedicalRecordPort medicalRecordPort) {
        this.medicalRecordPort = medicalRecordPort;
    }

    public void update(MedicalRecord medicalRecord) throws Exception {
        if (medicalRecord == null || medicalRecord.getPatientId() == null) {
            throw new Exception("Medical record or its patient ID cannot be null for update.");
        }

        // Verificar que exista una historia clínica para ese paciente
        var existingOpt = medicalRecordPort.findByPatientId(medicalRecord.getPatientId());
        if (existingOpt.isEmpty()) {
            throw new NotFoundException("La historia clínica no existe para el paciente " + medicalRecord.getPatientId());
        }

        medicalRecordPort.update(medicalRecord);
    }
}
