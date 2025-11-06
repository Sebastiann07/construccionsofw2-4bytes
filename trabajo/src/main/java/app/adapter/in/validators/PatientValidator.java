package app.adapter.in.validators;

import org.springframework.stereotype.Component;

/**
 * Valida los datos de los pacientes.
 */
@Component
public class PatientValidator {

    /**
     * Valida el ID del paciente.
     *
     * @param id ID del paciente
     * @return el mismo ID si es válido
     * @throws Exception si es nulo o vacío
     */
    public String idValidator(String id) throws Exception {
        if (id == null || id.trim().isEmpty()) {
            throw new Exception("El ID del paciente no puede estar vacío");
        }
        return id.trim();
    }
}
