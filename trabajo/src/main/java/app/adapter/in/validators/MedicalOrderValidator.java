package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class MedicalOrderValidator {

    public String doctorIdValidator(String doctorId) throws Exception {
        if (doctorId == null || doctorId.trim().isEmpty()) {
            throw new Exception("El ID del médico es obligatorio");
        }
        return doctorId.trim();
    }

    public String patientIdValidator(String patientId) throws Exception {
        if (patientId == null || patientId.trim().isEmpty()) {
            throw new Exception("El ID del paciente es obligatorio");
        }
        return patientId.trim();
    }

    public String dateValidator(String date) throws Exception {
        if (date == null || date.trim().isEmpty()) {
            throw new Exception("La fecha de la orden es obligatoria");
        }
        return date.trim();
    }

    public String observationsValidator(String obs) {
        return obs == null ? "" : obs.trim();
    }
}
