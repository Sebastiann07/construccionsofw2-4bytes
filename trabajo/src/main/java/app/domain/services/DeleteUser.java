package app.domain.services;

import org.springframework.stereotype.Service;
import app.domain.model.User;
import app.domain.ports.UserPort;

/**
 * Servicio de dominio para eliminar usuarios del sistema.
 */
@Service
public class DeleteUser {

    private final UserPort userPort;

    public DeleteUser(UserPort userPort) {
        this.userPort = userPort;
    }

    public void delete(User user) throws Exception {
        if (user == null) {
            throw new Exception("Debe especificar un usuario para eliminar");
        }

        User existingUser = userPort.findByUsername(user.getUsername());
        if (existingUser == null) {
            throw new Exception("El usuario no existe en el sistema");
        }

        userPort.delete(user);
    }
}