package app.infrastructure.persistence.mapper;

import app.domain.model.DiagnosticHelp;
import app.infrastructure.persistence.entities.DiagnosticHelpEntity;

public class DiagnosticHelpMapper {

    public static DiagnosticHelp toDomain(DiagnosticHelpEntity e) {
        if (e == null) return null;
        DiagnosticHelp d = new DiagnosticHelp();
        if (e.getOrderNumber() != null) d.setOrderNumber(e.getOrderNumber());
        if (e.getItemNumber() != null) d.setItemNumber(e.getItemNumber());
        d.setDiagnosticId(e.getDiagnosticId());
        d.setDiagnosticName(e.getDiagnosticName());
        if (e.getQuantity() != null) d.setQuantity(e.getQuantity());
        d.setCost(e.getCost());
        d.setRequiresSpecialist(e.isRequiresSpecialist());
        d.setSpecialistTypeId(e.getSpecialistTypeId());
        return d;
    }

    public static DiagnosticHelpEntity toEntity(DiagnosticHelp d) {
        if (d == null) return null;
        DiagnosticHelpEntity e = new DiagnosticHelpEntity();
        e.setOrderNumber(d.getOrderNumber());
        e.setItemNumber(d.getItemNumber());
        e.setDiagnosticId(d.getDiagnosticId());
        e.setDiagnosticName(d.getDiagnosticName());
        e.setQuantity(d.getQuantity());
        e.setCost(d.getCost());
        e.setRequiresSpecialist(d.isRequiresSpecialist());
        e.setSpecialistTypeId(d.getSpecialistTypeId());
        return e;
    }
}
