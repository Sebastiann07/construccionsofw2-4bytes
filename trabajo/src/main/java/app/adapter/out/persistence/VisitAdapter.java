package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Visit;
import app.domain.ports.VisitPort;
import app.infrastructure.persistence.entities.VisitEntity;
import app.infrastructure.persistence.mapper.VisitMapper;
import app.infrastructure.persistence.repository.VisitRepository;

@Service
public class VisitAdapter implements VisitPort {

    @Autowired
    private VisitRepository repository;

    @Override
    public void save(Visit visit) throws Exception {
        VisitEntity e = VisitMapper.toEntity(visit);
        repository.save(e);
    }
}
