package app.domain.model.enums;

/**
 * Tipos de diagnósticos o elementos facturables.
 */
public enum DiagnosticType {
    MEDICATION,     // Medicamento administrado
    PROCEDURE,      // Procedimiento realizado
    EXAM,           // Examen o control general (por ejemplo, visita de enfermería)
    DIAGNOSTIC,     // Ayuda diagnóstica
    VISIT           // (Opcional) Visita médica o de enfermería
}
