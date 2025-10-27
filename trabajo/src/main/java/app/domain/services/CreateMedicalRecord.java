package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.MedicalRecord;
import app.domain.ports.MedicalRecordPort;

/**
 * Servicio de dominio encargado de crear registros de historia clínica.
 * Valida la información básica antes de delegar la persistencia al puerto.
 */
@Service
public class CreateMedicalRecord {

    @Autowired
    private MedicalRecordPort medicalRecordPort;

    public CreateMedicalRecord(MedicalRecordPort medicalRecordPort) {
        this.medicalRecordPort = medicalRecordPort;
    }

    public void createMedicalRecord(MedicalRecord record) throws Exception {
        // Validación: el registro no puede ser nulo
        if (record == null) {
            throw new Exception("La historia clínica no puede ser nula");
        }

        // Validación: el ID del paciente es obligatorio
        if (record.getPatientId() == null || record.getPatientId().isEmpty()) {
            throw new Exception("La historia clínica debe estar asociada a un paciente válido");
        }

        // Validación: la fecha también es requerida
        if (record.getDate() == null || record.getDate().isEmpty()) {
            throw new Exception("La historia clínica debe tener una fecha de atención válida");
        }

        // Si pasa las validaciones, se guarda mediante el puerto
        medicalRecordPort.save(record);
    }
}
