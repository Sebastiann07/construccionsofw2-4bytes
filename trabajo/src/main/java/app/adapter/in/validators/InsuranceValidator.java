package app.adapter.in.validators;

import org.springframework.stereotype.Component;

import app.domain.model.Insurance;

@Component
public class InsuranceValidator {

    public void validate(Insurance insurance) throws Exception {
        if (insurance == null) {
            throw new Exception("La información del seguro no puede ser nula");
        }
        if (insurance.getInsuranceCompany() == null || insurance.getInsuranceCompany().trim().isEmpty()) {
            throw new Exception("La compañía de seguros es obligatoria");
        }
        if (insurance.getPolicyNumber() == null || insurance.getPolicyNumber().trim().isEmpty()) {
            throw new Exception("El número de póliza es obligatorio");
        }
        // policyEndDate puede ser opcional por ahora
    }
}
