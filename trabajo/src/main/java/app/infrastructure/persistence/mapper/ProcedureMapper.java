package app.infrastructure.persistence.mapper;

import app.domain.model.Procedure;
import app.infrastructure.persistence.entities.ProcedureEntity;

public class ProcedureMapper {

    public static Procedure toDomain(ProcedureEntity e) {
        if (e == null) return null;
        Procedure p = new Procedure();
        if (e.getOrderNumber() != null) p.setOrderNumber(e.getOrderNumber());
        if (e.getItemNumber() != null) p.setItemNumber(e.getItemNumber());
        p.setProcedureId(e.getProcedureId());
        p.setProcedureName(e.getProcedureName());
        if (e.getQuantity() != null) p.setQuantity(e.getQuantity());
        p.setFrequency(e.getFrequency());
        p.setCost(e.getCost());
        p.setRequiresSpecialist(e.isRequiresSpecialist());
        p.setSpecialistTypeId(e.getSpecialistTypeId());
        return p;
    }

    public static ProcedureEntity toEntity(Procedure p) {
        if (p == null) return null;
        ProcedureEntity e = new ProcedureEntity();
        e.setProcedureId(p.getProcedureId());
        e.setOrderNumber(p.getOrderNumber());
        e.setItemNumber(p.getItemNumber());
        e.setProcedureName(p.getProcedureName());
        e.setQuantity(p.getQuantity());
        e.setFrequency(p.getFrequency());
        e.setCost(p.getCost());
        e.setRequiresSpecialist(p.isRequiresSpecialist());
        e.setSpecialistTypeId(p.getSpecialistTypeId());
        return e;
    }
}
