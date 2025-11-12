package app.domain.ports;

import app.domain.model.User;
import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;

/**
 * Puerto para operaciones de autenticación basadas en JWT.
 * Se utiliza tanto para validar tokens entrantes como para generarlos al iniciar sesión.
 */
public interface AuthenticationPort {
    /**
     * Genera un JWT para el usuario autenticado.
     */
    String generateToken(User user);

    /**
     * Autentica credenciales y devuelve un TokenResponse con el token plano.
     */
    TokenResponse authenticate(AuthCredentials credentials, String role) throws Exception;

    boolean validateToken(String token);
    String extractUsername(String token);
    String extractRole(String token);
}
