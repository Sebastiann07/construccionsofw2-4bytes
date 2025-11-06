package app.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.MedicineEntity;

@Repository
public interface MedicineRepository extends JpaRepository<MedicineEntity, String> {
    Optional<MedicineEntity> findByMedicineName(String medicineName);
}
