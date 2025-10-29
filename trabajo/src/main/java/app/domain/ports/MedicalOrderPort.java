package app.domain.ports;

import java.util.List;

import app.domain.model.MedicalOrder;

/**
 * Puerto del dominio para operaciones de persistencia sobre órdenes médicas.
 */
public interface MedicalOrderPort {

    void save(MedicalOrder order) throws Exception;

    MedicalOrder findById(String id) throws Exception;

    List<MedicalOrder> findByPatient(String patientId) throws Exception;
}
