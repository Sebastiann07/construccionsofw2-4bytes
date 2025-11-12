package app.infrastructure.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.ports.UserPort;

/**
 * Inicializa datos básicos al arrancar la aplicación: crea un usuario ADMIN si no existe.
 * Evita tener que insertar manualmente para probar el login.
 */
@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner seedAdmin(UserPort userPort) {
        return args -> {
            try {
                String username = "admin";
                User existing = userPort.findByUsername(username);
                if (existing == null) {
                    User admin = new User();
                    admin.setUsername(username);
                    admin.setPassword("admin"); // Plain text while password hashing not enabled
                    admin.setFullName("Administrador Principal");
                    admin.setEmail("admin@example.com");
                    admin.setAddress("");
                    admin.setPhone("");
                    admin.setAge(0);
                    admin.setRole(Role.ADMIN);
                    userPort.save(admin);
                    System.out.println("[INIT] Usuario ADMIN creado (username=admin, password=admin)");
                } else {
                    System.out.println("[INIT] Usuario ADMIN ya existe - se omite creación");
                }
            } catch (Exception e) {
                System.err.println("[INIT] Error creando usuario admin: " + e.getMessage());
            }
        };
    }
}
