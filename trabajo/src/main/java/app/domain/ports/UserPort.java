package app.domain.ports;

import app.domain.model.User;

public interface UserPort {

    User findByUsername(String username) throws Exception;

    void save(User user);
}