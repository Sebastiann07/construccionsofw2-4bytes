package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;
import app.infrastructure.persistence.entities.PatientEntity;
import app.infrastructure.persistence.mapper.PatientMapper;
import app.infrastructure.persistence.repository.PatientRepository;

@Service
public class PatientAdapter implements PatientPort {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void save(Patient patient) throws Exception {
        PatientEntity entity = PatientMapper.toEntity(patient);
        patientRepository.save(entity);
        if (patient.getId() == 0 && entity.getId() != null) {
            patient.setId(entity.getId());
        }
    }

    @Override
    public Patient findById(long id) throws Exception {
        return patientRepository.findById(id).map(PatientMapper::toDomain).orElse(null);
    }

    @Override
    public void update(Patient patient) throws Exception {
        PatientEntity entity = PatientMapper.toEntity(patient);
        patientRepository.save(entity);
    }
}
