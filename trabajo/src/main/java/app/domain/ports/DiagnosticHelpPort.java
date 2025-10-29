package app.domain.ports;

import app.domain.model.DiagnosticHelp;

/**
 * Puerto del dominio para la gestión de ayudas diagnósticas.
 */
public interface DiagnosticHelpPort {

    /**
     * Guarda una ayuda diagnóstica.
     */
    void save(DiagnosticHelp help) throws Exception;

    /**
     * Busca una ayuda diagnóstica por número de orden o ID.
     */
    DiagnosticHelp findByOrderNumber(int orderNumber) throws Exception;
}
