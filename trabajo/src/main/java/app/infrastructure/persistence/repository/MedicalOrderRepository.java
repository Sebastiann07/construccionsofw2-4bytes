package app.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.MedicalOrderEntity;

@Repository
public interface MedicalOrderRepository extends JpaRepository<MedicalOrderEntity, String> {
    List<MedicalOrderEntity> findByPatientId(String patientId);
}
