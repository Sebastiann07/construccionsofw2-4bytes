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

        if (record.getDoctorId() == null || record.getDoctorId().isEmpty()) {
            throw new Exception("Debe especificar un ID de médico válido");
        }

        if (record.getDiagnosis() == null || record.getDiagnosis().isEmpty()) {
            throw new Exception("Debe especificar un diagnóstico válido");
        }

        if (record.getDate() == null || record.getDate().isEmpty()) {
            throw new Exception("Debe especificar la fecha del registro");
        }

        medicalRecordPort.save(record);
    }
}
