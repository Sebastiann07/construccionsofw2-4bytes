package app.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.ProcedureEntity;

@Repository
public interface ProcedureRepository extends JpaRepository<ProcedureEntity, String> {
    Optional<ProcedureEntity> findByProcedureName(String procedureName);
}
