package app.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.CopayRecordEntity;

@Repository
public interface CopayRecordRepository extends JpaRepository<CopayRecordEntity, Long> {
    List<CopayRecordEntity> findByPatientId(String patientId);
}
