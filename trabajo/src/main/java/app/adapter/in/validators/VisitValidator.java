package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class VisitValidator {

    public String patientIdValidator(String patientId) throws Exception {
        if (patientId == null || patientId.trim().isEmpty()) {
            throw new Exception("El ID del paciente es obligatorio");
        }
        return patientId.trim();
    }

    public String nurseIdValidator(String nurseId) throws Exception {
        if (nurseId == null || nurseId.trim().isEmpty()) {
            throw new Exception("El ID de la enfermera es obligatorio");
        }
        return nurseId.trim();
    }
}
