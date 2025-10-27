package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Insurance;
import app.domain.ports.InsurancePort;

/**
 * Maneja el registro de seguros y la validación básica.
 */
@Service
public class CreateInsurance {

    @Autowired
    private InsurancePort insurancePort;

    public CreateInsurance(InsurancePort insurancePort) {
        this.insurancePort = insurancePort;
    }

    public void createInsurance(Insurance insurance) throws Exception {
        if (insurance == null) {
            throw new Exception("Insurance cannot be null");
        }

        if (insurance.getPolicyNumber() == null || insurance.getPolicyNumber().isEmpty()) {
            throw new Exception("Insurance must have a valid policy number");
        }

        if (insurancePort.findByPolicyNumber(insurance.getPolicyNumber()) != null) {
            throw new Exception("An insurance policy with this number already exists");
        }

        insurancePort.save(insurance);
    }
}
