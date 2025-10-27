package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.User;
import app.domain.ports.UserPort;

/**
* Handes user registration and validation logic.
* Maneja el registro de usuarios y la lógica de validación.
 */
@Service
public class CreateUser {

    @Autowired
    private UserPort userPort;

    public CreateUser(UserPort userPort) {
        this.userPort = userPort;
    }

    public void createUser(User user) throws Exception {
        if (user == null) {
            throw new Exception("Usuario no puede ser Nulo");
        }

        if (userPort.findById(user.getId()) != null) {
            throw new Exception("Un usuario con esta ID ya existe");
        }

        if (userPort.findByUsername(user.getUsername()) != null) {
            throw new Exception("Este nombre de usuario ya existe");
        }

        userPort.save(user);
    }
}
