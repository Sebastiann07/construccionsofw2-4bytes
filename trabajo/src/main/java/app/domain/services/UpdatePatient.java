package app.domain.services;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;
import org.springframework.stereotype.Service;

@Service
public class UpdatePatient {

    private final PatientPort patientPort;

    public UpdatePatient(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public void updatePatient(Patient patient) throws Exception {
        if (patient == null) {
            throw new Exception("El paciente no puede ser nulo");
        }
        patientPort.update(patient);
    }
}
