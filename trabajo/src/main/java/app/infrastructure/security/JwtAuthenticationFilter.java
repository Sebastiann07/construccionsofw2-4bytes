package app.infrastructure.security;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import app.domain.ports.AuthenticationPort;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    
    @Autowired
    private AuthenticationPort authenticationPort;

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                  HttpServletResponse response, 
                                  FilterChain filterChain) throws ServletException, IOException {
        String token = this.extractToken(request);
        
        if (token != null) {
            this.processToken(token);
        }
        
        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }

    private void processToken(String token) {
        if (authenticationPort != null && authenticationPort.validateToken(token)) {
            String username = authenticationPort.extractUsername(token);
            String role = authenticationPort.extractRole(token);

            // Debug simple para diagnosticar 403 por falta de rol/autoridades
            System.out.println("[JWT] Token válido. subject=" + username + ", role claim=" + role);

            if (role == null || role.trim().isEmpty()) {
                System.out.println("[JWT] Token sin rol. Se omite autenticación");
                return; // no role -> no authentication
            }

            String normalized = role.trim();
            if (!normalized.toUpperCase().startsWith("ROLE_")) {
                normalized = "ROLE_" + normalized.toUpperCase();
            } else {
                normalized = normalized.toUpperCase();
            }

            ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(normalized));
            
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                username, 
                null, 
                authorities
            );
            
            SecurityContextHolder.getContext().setAuthentication(auth);
            System.out.println("[JWT] Autenticación establecida con autoridad=" + normalized);
        }
        else {
            System.out.println("[JWT] Token inválido o no se pudo validar. No se establece autenticación");
        }
    }
}
