package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Procedure;
import app.domain.ports.ProcedurePort;
import app.infrastructure.persistence.entities.ProcedureEntity;
import app.infrastructure.persistence.mapper.ProcedureMapper;
import app.infrastructure.persistence.repository.ProcedureRepository;

@Service
public class ProcedureAdapter implements ProcedurePort {

    @Autowired
    private ProcedureRepository procedureRepository;

    @Override
    public void save(Procedure procedure) throws Exception {
        ProcedureEntity entity = ProcedureMapper.toEntity(procedure);
        procedureRepository.save(entity);
    }

    @Override
    public Procedure findByName(String name) throws Exception {
        return procedureRepository.findByProcedureName(name).map(ProcedureMapper::toDomain).orElse(null);
    }
}
