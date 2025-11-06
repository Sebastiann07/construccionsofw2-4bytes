package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Invoice;
import app.domain.ports.InvoicePort;
import app.infrastructure.persistence.entities.InvoiceEntity;
import app.infrastructure.persistence.mapper.InvoiceMapper;
import app.infrastructure.persistence.repository.InvoiceRepository;

@Service
public class InvoiceAdapter implements InvoicePort {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public void save(Invoice invoice) throws Exception {
        InvoiceEntity entity = InvoiceMapper.toEntity(invoice);
        invoiceRepository.save(entity);
    }

    @Override
    public Invoice findById(String id) throws Exception {
        return invoiceRepository.findById(id).map(InvoiceMapper::toDomain).orElse(null);
    }
}
