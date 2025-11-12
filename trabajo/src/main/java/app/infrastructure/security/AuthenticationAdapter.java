package app.infrastructure.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import app.domain.model.User;
import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;
import app.domain.ports.AuthenticationPort;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

/**
 * Implementación basada en JWT del puerto de autenticación.
 * Genera y valida tokens firmados con HS256.
 */
@Component
public class AuthenticationAdapter implements AuthenticationPort {

    @Value("${jwt.secret:ChangeThisSecretKeyPleaseAtLeast32Chars}")
    private String secret;

    @Value("${jwt.expirationMillis:3600000}")
    private long expirationMillis;

    private SecretKey getKey() {
        // Permite secrets en Base64 o texto plano (se codifica si no está en Base64)
        try {
            byte[] decoded = Decoders.BASE64.decode(secret);
            return Keys.hmacShaKeyFor(decoded);
        } catch (IllegalArgumentException ex) {
            return Keys.hmacShaKeyFor(secret.getBytes());
        }
    }

    @Override
    public String generateToken(User user) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + expirationMillis);

        return Jwts.builder()
            .setSubject(user.getUsername())
            .claim("role", user.getRole() != null ? user.getRole().name() : null)
            .setIssuedAt(now)
            .setExpiration(exp)
            .signWith(getKey(), SignatureAlgorithm.HS256)
            .compact();
    }

    @Override
    public TokenResponse authenticate(AuthCredentials credentials, String role) throws Exception {
        //  la verificación de contraseña ocurre fuera (AuthenticationService).
        // Aquí solo generamos el token usando username + role.
        User u = new User();
        u.setUsername(credentials.getUsername());
        // role llega como String (por ejemplo DOCTOR); lo incluimos como claim
        Date now = new Date();
        Date exp = new Date(now.getTime() + expirationMillis);
        String token = Jwts.builder()
                .setSubject(credentials.getUsername())
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
        return new TokenResponse(token);
    }

    @Override
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Claims extractClaims(String token) {
        try {
            Jws<Claims> jws = Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token);
            return jws.getBody();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String extractUsername(String token) {
        Claims c = extractClaims(token);
        return c != null ? c.getSubject() : null;
    }

    @Override
    public String extractRole(String token) {
        Claims c = extractClaims(token);
        Object role = c != null ? c.get("role") : null;
        return role != null ? role.toString() : null;
    }
}
