package app.domain.services;

import org.springframework.stereotype.Service;
import app.domain.model.User;
import app.domain.ports.UserPort;
import app.application.exceptions.NotFoundException;

/**
 * Servicio de dominio para eliminar usuarios del sistema.
 */
@Service
public class DeleteUser {

    private final UserPort userPort;

    public DeleteUser(UserPort userPort) {
        this.userPort = userPort;
    }

    public void delete(long userId) throws Exception {
        if (userId <= 0) {
            throw new Exception("Debe especificar un ID de usuario para eliminar");
        }

        User existingUser = userPort.findById(userId);
        if (existingUser == null) {
            throw new NotFoundException("El usuario no existe en el sistema");
        }

        userPort.delete(existingUser);
    }
}
