package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;

/**
* Servicio de dominio responsable de la lógica de creación de pacientes.
* Garantiza la identificación única y delega la persistencia al PatientPort.
 */
@Service
public class CreatePatient {

    @Autowired
    private PatientPort patientPort;

    public CreatePatient(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public void createPatient(Patient patient) throws Exception {
        if (patient == null) {
            throw new Exception("Paciente no puede ser nulo");
        }

        if (patientPort.findById(patient.getId()) != null) {
            throw new Exception("Un paciente con esta ID ya existe");
        }

        patientPort.save(patient);
    }
}
