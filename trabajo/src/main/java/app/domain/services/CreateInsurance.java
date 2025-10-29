package app.domain.services;

import org.springframework.stereotype.Service;

import app.domain.model.Insurance;
import app.domain.ports.InsurancePort;

/**
 * Caso de uso: gestionar seguros médicos.
 */
@Service
public class CreateInsurance {

    private final InsurancePort insurancePort;

    public CreateInsurance(InsurancePort insurancePort) {
        this.insurancePort = insurancePort;
    }

    public void createInsurance(Insurance insurance) throws Exception {
        if (insurance == null) {
            throw new Exception("El seguro no puede ser nulo");
        }

        if (insurance.getInsuranceCompany() == null || insurance.getInsuranceCompany().isEmpty()) {
            throw new Exception("El seguro debe tener una compañía válida");
        }

        if (insurance.getPolicyNumber() == null || insurance.getPolicyNumber().isEmpty()) {
            throw new Exception("El seguro debe tener un número de póliza válido");
        }

        insurancePort.save(insurance);
    }

}
