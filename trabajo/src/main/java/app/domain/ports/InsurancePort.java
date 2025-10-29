package app.domain.ports;

import app.domain.model.Insurance;

/**
 * Puerto del dominio para la gestión de seguros médicos.
 */
public interface InsurancePort {

    /**
     * Guarda la información de un seguro médico.
     */
    void save(Insurance insurance) throws Exception;

    /**
     * Busca un seguro médico por su número de póliza.
     */
    Insurance findByPolicyNumber(String policyNumber) throws Exception;
}
