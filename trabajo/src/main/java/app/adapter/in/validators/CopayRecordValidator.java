package app.adapter.in.validators;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class CopayRecordValidator {

    public String patientIdValidator(String patientId) throws Exception {
        if (patientId == null || patientId.trim().isEmpty()) {
            throw new Exception("El ID del paciente es obligatorio");
        }
        return patientId.trim();
    }

    public double copayAmountValidator(Double amount) throws Exception {
        if (amount == null || amount < 0) {
            throw new Exception("El copago no puede ser negativo");
        }
        return amount;
    }

    public LocalDate dateValidator(LocalDate date) throws Exception {
        if (date == null) {
            throw new Exception("La fecha es obligatoria");
        }
        return date;
    }
}
