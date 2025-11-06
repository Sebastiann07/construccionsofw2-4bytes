package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Insurance;
import app.domain.ports.InsurancePort;
import app.infrastructure.persistence.entities.InsuranceEntity;
import app.infrastructure.persistence.mapper.InsuranceMapper;
import app.infrastructure.persistence.repository.InsuranceRepository;

@Service
public class InsuranceAdapter implements InsurancePort {

    @Autowired
    private InsuranceRepository repository;

    @Override
    public void save(Insurance insurance) throws Exception {
        InsuranceEntity e = InsuranceMapper.toEntity(insurance);
        repository.save(e);
    }

    @Override
    public Insurance findByPolicyNumber(String policyNumber) throws Exception {
        return repository.findById(policyNumber).map(InsuranceMapper::toDomain).orElse(null);
    }
}
