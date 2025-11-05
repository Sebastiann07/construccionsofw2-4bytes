package app.domain.services;

import org.springframework.stereotype.Service;

import app.domain.model.MedicalRecord;
import app.domain.ports.MedicalRecordPort;

/**
 * Caso de uso: registrar el historial médico de un paciente.
 */
@Service
public class CreateMedicalRecord {

    private final MedicalRecordPort medicalRecordPort;

    public CreateMedicalRecord(MedicalRecordPort medicalRecordPort) {
        this.medicalRecordPort = medicalRecordPort;
    }

    public void create(MedicalRecord record) throws Exception {
        if (record == null) {
            throw new Exception("El registro médico no puede ser nulo");
        }

        if (record.getPatientId() == null || record.getPatientId().isEmpty()) {
            throw new Exception("Debe especificar el ID del paciente");
        }

        if (record.getData() == null || record.getData().isEmpty()) {
            throw new Exception("Debe incluir información en la historia clínica");
        }

        medicalRecordPort.save(record);
    }
}
