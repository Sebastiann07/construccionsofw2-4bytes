package app.domain.services;

import org.springframework.stereotype.Service;

import app.domain.model.User;
import app.domain.ports.UserPort;

/**
 * Caso de uso: registrar usuarios del sistema (médicos, enfermeros, administrativos).
 */
@Service
public class CreateUser {

    private final UserPort userPort;

    public CreateUser(UserPort userPort) {
        this.userPort = userPort;
    }

    public void create(User user) throws Exception {
        if (user == null) {
            throw new Exception("El usuario no puede ser nulo");
        }

        if (userPort.findById(user.getId()) != null) {
            throw new Exception("Un usuario con esta ID ya existe");
        }

        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new Exception("El usuario debe tener un nombre de usuario válido");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new Exception("El usuario debe tener una contraseña válida");
        }

        userPort.save(user);
    }
}
