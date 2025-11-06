package app.infrastructure.persistence.mapper;

import app.domain.model.InvoiceDetail;
import app.domain.model.enums.DiagnosticType;
import app.infrastructure.persistence.entities.InvoiceDetailEntity;

public class InvoiceDetailMapper {

    public static InvoiceDetail toDomain(InvoiceDetailEntity e) {
        if (e == null) return null;
        InvoiceDetail d = new InvoiceDetail();
        if (e.getDiagnosticType() != null) {
            try { d.setDiagnosticType(DiagnosticType.valueOf(e.getDiagnosticType())); } catch (IllegalArgumentException ex) { /* ignore */ }
        }
        d.setName(e.getName());
        d.setCost(e.getCost());
        d.setDose(e.getDose());
        return d;
    }

    public static InvoiceDetailEntity toEntity(InvoiceDetail d) {
        if (d == null) return null;
        InvoiceDetailEntity e = new InvoiceDetailEntity();
        e.setDiagnosticType(d.getDiagnosticType() != null ? d.getDiagnosticType().name() : null);
        e.setName(d.getName());
        e.setCost(d.getCost());
        e.setDose(d.getDose());
        return e;
    }
}
