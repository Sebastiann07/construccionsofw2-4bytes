package app.adapter.out.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.MedicalRecord;
import app.domain.ports.MedicalRecordPort;
import app.infrastructure.persistence.entities.MedicalRecordEntity;
import app.infrastructure.persistence.mapper.MedicalRecordMapper;
import app.infrastructure.persistence.repository.MedicalRecordRepository;

@Service
public class MedicalRecordAdapter implements MedicalRecordPort {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Override
    public void save(MedicalRecord record) throws Exception {
        MedicalRecordEntity entity = MedicalRecordMapper.toEntity(record);
        medicalRecordRepository.save(entity);
    }

    @Override
    public Optional<MedicalRecord> findByPatientId(String patientId) throws Exception {
        Optional<MedicalRecordEntity> entityOpt = medicalRecordRepository.findByPatientId(patientId);
        return entityOpt.map(MedicalRecordMapper::toDomain);
    }

    @Override
    public void update(MedicalRecord record) throws Exception {
        // La actualización se maneja igual que save, JPA hace upsert
        MedicalRecordEntity entity = MedicalRecordMapper.toEntity(record);
        medicalRecordRepository.save(entity);
    }
}
