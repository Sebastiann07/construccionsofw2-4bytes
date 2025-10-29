package app.domain.services;

import org.springframework.stereotype.Service;

import app.domain.model.Procedure;
import app.domain.ports.ProcedurePort;

/**
 * Caso de uso: gestionar procedimientos médicos en la clínica.
 * Valida la información antes de registrar un procedimiento.
 */
@Service
public class CreateProcedure {

    private final ProcedurePort procedurePort;

    public CreateProcedure(ProcedurePort procedurePort) {
        this.procedurePort = procedurePort;
    }

    public void create(Procedure procedure) throws Exception {
        if (procedure == null) {
            throw new Exception("El procedimiento no puede ser nulo");
        }

        if (procedure.getProcedureId() == null || procedure.getProcedureId().isEmpty()) {
            throw new Exception("El procedimiento debe tener un ID válido");
        }

        if (procedure.getQuantity() <= 0) {
            throw new Exception("La cantidad debe ser mayor a cero");
        }

        if (procedure.getOrderNumber() <= 0) {
            throw new Exception("El número de orden debe ser válido");
        }

        procedurePort.save(procedure);
    }
}
