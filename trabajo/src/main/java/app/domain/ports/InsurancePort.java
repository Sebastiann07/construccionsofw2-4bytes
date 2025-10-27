package app.domain.ports;

import app.domain.model.Insurance;

/**
 * Contrato para la gestión de pólizas de seguros de pacientes.
 */
public interface InsurancePort {
    Insurance findByPolicyNumber(String policyNumber) throws Exception;
    void save(Insurance insurance) throws Exception;
}
