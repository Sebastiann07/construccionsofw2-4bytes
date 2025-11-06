package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Invoice;
import app.domain.ports.BillingPort;
import app.infrastructure.persistence.entities.InvoiceEntity;
import app.infrastructure.persistence.mapper.InvoiceMapper;
import app.infrastructure.persistence.repository.InvoiceRepository;

@Service
public class BillingAdapter implements BillingPort {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public Invoice save(Invoice invoice) {
        InvoiceEntity e = InvoiceMapper.toEntity(invoice);
        InvoiceEntity saved = invoiceRepository.save(e);
        return InvoiceMapper.toDomain(saved);
    }
}
