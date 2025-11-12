package app.infrastructure.adapter.in.rest.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.application.usecases.LoginUseCase;
import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;
import app.infrastructure.adapter.in.rest.auth.request.AuthRequest;
import app.infrastructure.adapter.in.rest.auth.response.TokenResponseDto;

@RestController
@RequestMapping("/api/auth")
@Validated
public class AuthController {

    private final LoginUseCase loginUseCase;
    private final AuthRestMapper authRestMapper;

    public AuthController(LoginUseCase loginUseCase, AuthRestMapper authRestMapper) {
        this.loginUseCase = loginUseCase;
        this.authRestMapper = authRestMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody @Validated AuthRequest request) throws Exception {
        AuthCredentials credentials = authRestMapper.toDomain(request);
        TokenResponse token = loginUseCase.login(credentials);
        return ResponseEntity.ok(authRestMapper.toResponse(token));
    }
}