package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.DiagnosticHelp;
import app.domain.ports.DiagnosticHelpPort;
import app.infrastructure.persistence.entities.DiagnosticHelpEntity;
import app.infrastructure.persistence.mapper.DiagnosticHelpMapper;
import app.infrastructure.persistence.repository.DiagnosticHelpRepository;

@Service
public class DiagnosticHelpAdapter implements DiagnosticHelpPort {

    @Autowired
    private DiagnosticHelpRepository repository;

    @Override
    public void save(DiagnosticHelp help) throws Exception {
        DiagnosticHelpEntity e = DiagnosticHelpMapper.toEntity(help);
        repository.save(e);
    }

    @Override
    public DiagnosticHelp findByOrderNumber(int orderNumber) throws Exception {
        return repository.findFirstByOrderNumber(orderNumber)
                .map(DiagnosticHelpMapper::toDomain)
                .orElse(null);
    }
}
