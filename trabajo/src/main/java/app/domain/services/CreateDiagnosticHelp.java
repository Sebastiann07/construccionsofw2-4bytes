package app.domain.services;

import org.springframework.stereotype.Service;

import app.domain.model.DiagnosticHelp;
import app.domain.ports.DiagnosticHelpPort;

/**
 * Caso de uso: gestionar ayudas diagnósticas en la clínica.
 * Incluye validaciones antes de guardar.
 */
@Service
public class CreateDiagnosticHelp {

    private final DiagnosticHelpPort diagnosticHelpPort;

    public CreateDiagnosticHelp(DiagnosticHelpPort diagnosticHelpPort) {
        this.diagnosticHelpPort = diagnosticHelpPort;
    }

    public void create(DiagnosticHelp diagnosticHelp) throws Exception {
        if (diagnosticHelp == null) {
            throw new Exception("La ayuda diagnóstica no puede ser nula");
        }

        if (diagnosticHelp.getDiagnosticId() == null || diagnosticHelp.getDiagnosticId().isEmpty()) {
            throw new Exception("Debe especificar un ID de diagnóstico válido");
        }

        if (diagnosticHelp.getOrderNumber() <= 0) {
            throw new Exception("Debe existir un número de orden válido");
        }

        diagnosticHelpPort.save(diagnosticHelp);
    }
}
