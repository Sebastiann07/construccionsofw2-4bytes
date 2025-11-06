package app.adapter.in.validators;

import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * Valida los datos del registro médico.
 */
@Component
public class MedicalRecordValidator {

    /**
     * Valida el mapa de datos médicos (no estructurado).
     *
     * @param data Mapa con la información médica
     * @return el mismo mapa si es válido
     * @throws Exception si está vacío o nulo
     */
    public Map<String, Object> dataValidator(Map<String, Object> data) throws Exception {
        if (data == null || data.isEmpty()) {
            throw new Exception("El contenido del historial médico no puede estar vacío");
        }
        return data;
    }
}
