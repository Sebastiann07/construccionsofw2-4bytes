package app.adapter.out.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.CopayRecord;
import app.domain.ports.CopayPort;
import app.infrastructure.persistence.entities.CopayRecordEntity;
import app.infrastructure.persistence.mapper.CopayRecordMapper;
import app.infrastructure.persistence.repository.CopayRecordRepository;

@Service
public class CopayAdapter implements CopayPort {

    @Autowired
    private CopayRecordRepository repository;

    @Override
    public List<CopayRecord> findByPatientId(String patientId) {
        return repository.findByPatientId(patientId)
                .stream()
                .map(CopayRecordMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void save(CopayRecord copayRecord) {
        CopayRecordEntity e = CopayRecordMapper.toEntity(copayRecord);
        repository.save(e);
    }
}
