package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.EmergencyContact;
import app.domain.ports.EmergencyContactPort;
import app.infrastructure.persistence.entities.EmergencyContactEntity;
import app.infrastructure.persistence.mapper.EmergencyContactMapper;
import app.infrastructure.persistence.repository.EmergencyContactRepository;

@Service
public class EmergencyContactAdapter implements EmergencyContactPort {

    @Autowired
    private EmergencyContactRepository repository;

    @Override
    public void save(EmergencyContact contact) throws Exception {
        EmergencyContactEntity e = EmergencyContactMapper.toEntity(contact);
        repository.save(e);
    }

    @Override
    public EmergencyContact findByPhone(String phone) throws Exception {
        return repository.findByEmergencyContactPhone(phone)
                .map(EmergencyContactMapper::toDomain)
                .orElse(null);
    }
}
