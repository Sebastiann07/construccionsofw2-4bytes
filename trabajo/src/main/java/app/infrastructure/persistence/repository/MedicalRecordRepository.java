package app.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.MedicalRecordEntity;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecordEntity, Long> {
    Optional<MedicalRecordEntity> findByPatientId(String patientId);
}
