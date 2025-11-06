package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.InvoiceDetail;
import app.domain.ports.InvoiceDetailPort;
import app.infrastructure.persistence.entities.InvoiceDetailEntity;
import app.infrastructure.persistence.mapper.InvoiceDetailMapper;
import app.infrastructure.persistence.repository.InvoiceDetailRepository;

@Service
public class InvoiceDetailAdapter implements InvoiceDetailPort {

    @Autowired
    private InvoiceDetailRepository repository;

    @Override
    public void save(InvoiceDetail invoiceDetail) throws Exception {
        InvoiceDetailEntity e = InvoiceDetailMapper.toEntity(invoiceDetail);
        repository.save(e);
    }
}
