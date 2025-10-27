package app.domain.ports;

import app.domain.model.User;
/**
* Define el contrato de persistencia para los usuarios del sistema.
 */
public interface UserPort {
    User findById(long id) throws Exception;
    User findByUsername(String username) throws Exception;
    void save(User user) throws Exception;
}
