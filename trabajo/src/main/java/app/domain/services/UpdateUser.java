package app.domain.services;

import org.springframework.stereotype.Service;
import app.domain.model.User;
import app.domain.ports.UserPort;
import app.application.exceptions.NotFoundException;

/**
 * Servicio de dominio para actualizar datos de usuarios existentes.
 */
@Service
public class UpdateUser {

    private final UserPort userPort;

    public UpdateUser(UserPort userPort) {
        this.userPort = userPort;
    }

    public void update(User user) throws Exception {
        if (user == null) {
            throw new Exception("El usuario no puede ser nulo");
        }

        User existingUser = userPort.findByUsername(user.getUsername());
        if (existingUser == null) {
            throw new NotFoundException("No existe un usuario con este nombre");
        }

        userPort.update(user); // Reutilizamos update() para actualizar
    }
}