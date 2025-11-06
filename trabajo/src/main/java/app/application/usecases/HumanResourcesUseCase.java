package app.application.usecases;

import org.springframework.stereotype.Service;
import app.domain.model.User;
import app.domain.services.CreateUser;
import app.domain.services.DeleteUser;
import app.domain.services.UpdateUser;

/**
 * Caso de uso para el rol de Recursos Humanos.
 * Se encarga de gestionar usuarios del sistema (crear, actualizar, eliminar).
 */
@Service
public class HumanResourcesUseCase {

    private final CreateUser createUser;
    private final DeleteUser deleteUser;
    private final UpdateUser updateUser;

    public HumanResourcesUseCase(CreateUser createUser, DeleteUser deleteUser, UpdateUser updateUser) {
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
    }

    /**
     * Crear un nuevo usuario en el sistema.
     */
    public void createUser(User user) throws Exception {
        if (user == null) {
            throw new Exception("El usuario no puede ser nulo");
        }

        createUser.create(user);
    }

    /**
     * Actualizar los datos de un usuario existente.
     */
    public void updateUser(User user) throws Exception {
        if (user == null) {
            throw new Exception("El usuario no puede ser nulo");
        }

        updateUser.update(user);
    }

    /**
     * Eliminar un usuario del sistema.
     */
    public void deleteUser(String userId) throws Exception {
        deleteUser.delete(userId);
    }
}