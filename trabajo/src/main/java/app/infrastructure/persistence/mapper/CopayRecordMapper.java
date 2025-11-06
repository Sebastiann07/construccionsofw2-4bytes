package app.infrastructure.persistence.mapper;

import app.domain.model.CopayRecord;
import app.infrastructure.persistence.entities.CopayRecordEntity;

public class CopayRecordMapper {

    public static CopayRecord toDomain(CopayRecordEntity e) {
        if (e == null) return null;
        return new CopayRecord(e.getPatientId(), e.getCopayAmount(), e.getDate());
    }

    public static CopayRecordEntity toEntity(CopayRecord r) {
        if (r == null) return null;
        CopayRecordEntity e = new CopayRecordEntity();
        e.setPatientId(r.getPatientId());
        e.setCopayAmount(r.getCopayAmount());
        e.setDate(r.getDate());
        return e;
    }
}
