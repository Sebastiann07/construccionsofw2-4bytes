package app.adapter.in.validators;

import org.springframework.stereotype.Component;

/**
 * Valida los datos de un usuario (médico, enfermero, administrador, etc.).
 */
@Component
public class UserValidator {

    /**
     * Valida el documento o ID de un usuario.
     *
     * @param document Documento del usuario
     * @return el mismo documento si es válido
     * @throws Exception si es nulo o vacío
     */
    public String documentValidator(String document) throws Exception {
        if (document == null || document.trim().isEmpty()) {
            throw new Exception("El documento del usuario no puede estar vacío");
        }
        return document.trim();
    }
}
