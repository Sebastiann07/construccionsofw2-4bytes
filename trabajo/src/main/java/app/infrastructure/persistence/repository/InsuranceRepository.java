package app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.InsuranceEntity;

@Repository
public interface InsuranceRepository extends JpaRepository<InsuranceEntity, String> {
}
