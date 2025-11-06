package app.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.VitalSignsEntity;

@Repository
public interface VitalSignsRepository extends JpaRepository<VitalSignsEntity, Long> {
    Optional<VitalSignsEntity> findByPatientId(Long patientId);
}
