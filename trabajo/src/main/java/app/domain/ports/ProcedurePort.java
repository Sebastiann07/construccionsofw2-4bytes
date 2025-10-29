package app.domain.ports;

import app.domain.model.Procedure;

/**
 * Puerto del dominio para la gestión de procedimientos médicos.
 */
public interface ProcedurePort {

    /**
     * Guarda un nuevo procedimiento médico.
     */
    void save(Procedure procedure) throws Exception;

    /**
     * Busca un procedimiento por su nombre o código.
     */
    Procedure findByName(String name) throws Exception;
}
