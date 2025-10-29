package app.domain.ports;

import app.domain.model.User;

/**
 * Puerto del dominio para los usuarios del sistema (médicos, enfermeros, administrativos, etc.).
 */
public interface UserPort {

    /**
     * Guarda un nuevo usuario.
     */
    void save(User user) throws Exception;

    /**
     * Busca un usuario por su ID.
     */
    User findById(long id) throws Exception;

    /**
     * Busca un usuario por su nombre de usuario (username).
     */
    User findByUsername(String username) throws Exception;
}
