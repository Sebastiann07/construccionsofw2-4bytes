package app.domain.model;

import app.domain.model.enums.Role;


public class User extends Person {

    private String username;     // Nombre de usuario único
    private String password;     // Contraseña del usuario
    private Role role;           // Rol asignado (DOCTOR, NURSE, etc.)

    public User() {}  // Constructor vacío (requerido por frameworks y consistente con Person)

    // === Getters y Setters ===
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
}