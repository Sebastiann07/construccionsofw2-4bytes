package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.VitalSigns;
import app.domain.ports.VitalSignsPort;
import app.infrastructure.persistence.entities.VitalSignsEntity;
import app.infrastructure.persistence.mapper.VitalSignsMapper;
import app.infrastructure.persistence.repository.VitalSignsRepository;

@Service
public class VitalSignsAdapter implements VitalSignsPort {

    @Autowired
    private VitalSignsRepository repository;

    @Override
    public void save(long patientId, VitalSigns vitalSigns) throws Exception {
        VitalSignsEntity e = VitalSignsMapper.toEntity(patientId, vitalSigns);
        repository.save(e);
    }

    @Override
    public VitalSigns findByPatientId(long patientId) throws Exception {
        return repository.findByPatientId(patientId).map(VitalSignsMapper::toDomain).orElse(null);
    }
}
