package app.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;
import app.domain.services.AuthenticationService;

@ExtendWith(MockitoExtension.class)
class LoginUseCaseTest {

    @Mock
    private AuthenticationService authenticationService;

    @Test
    void loginReturnsTokenFromService() throws Exception {
        // Arrange
        LoginUseCase useCase = new LoginUseCase(authenticationService);
        when(authenticationService.authenticate(any(AuthCredentials.class)))
            .thenReturn(new TokenResponse("demo-token"));
        AuthCredentials creds = new AuthCredentials();
        creds.setUsername("user1");
        creds.setPassword("pw");

        // Act
        TokenResponse result = useCase.login(creds);

        // Assert
        assertEquals("demo-token", result.getToken());
    }
}