package app.infrastructure.adapter.in.rest.auth;

import org.springframework.stereotype.Component;

import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;
import app.infrastructure.adapter.in.rest.auth.request.AuthRequest;
import app.infrastructure.adapter.in.rest.auth.response.TokenResponseDto;

@Component
public class AuthRestMapper {
    public AuthCredentials toDomain(AuthRequest req) {
        AuthCredentials c = new AuthCredentials();
        c.setUsername(req.getUsername());
        c.setPassword(req.getPassword());
        return c;
    }

    public TokenResponseDto toResponse(TokenResponse token) {
        return new TokenResponseDto(token.getToken());
    }
}