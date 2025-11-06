package app.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.DiagnosticHelpEntity;

@Repository
public interface DiagnosticHelpRepository extends JpaRepository<DiagnosticHelpEntity, String> {
    Optional<DiagnosticHelpEntity> findFirstByOrderNumber(Integer orderNumber);
}
