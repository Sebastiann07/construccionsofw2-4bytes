package app.application.usecases;

import org.springframework.stereotype.Component;

import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;
import app.domain.services.AuthenticationService;

/**
 * Caso de uso para autenticar usuarios del sistema y emitir un JWT.
 */
@Component
public class LoginUseCase {

    private final AuthenticationService authenticationService;

    public LoginUseCase(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public TokenResponse login(AuthCredentials credentials) throws Exception {
        return authenticationService.authenticate(credentials);
    }
}