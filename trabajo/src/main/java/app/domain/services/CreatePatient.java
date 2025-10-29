package app.domain.services;

import org.springframework.stereotype.Service;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;

/**
 * Caso de uso: registrar pacientes en la clínica.
 * Aplica validaciones básicas antes de guardar.
 */
@Service
public class CreatePatient {

    private final PatientPort patientPort;

    public CreatePatient(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public void createPatient(Patient patient) throws Exception {
        if (patient == null) {
            throw new Exception("El paciente no puede ser nulo");
        }

        if (patientPort.findById(patient.getId()) != null) {
            throw new Exception("Ya existe un paciente con este documento");
        }

        patientPort.save(patient);
    }
}
