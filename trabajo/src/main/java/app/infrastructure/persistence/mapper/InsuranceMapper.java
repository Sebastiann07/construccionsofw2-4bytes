package app.infrastructure.persistence.mapper;

import app.domain.model.Insurance;
import app.infrastructure.persistence.entities.InsuranceEntity;

public class InsuranceMapper {

    public static Insurance toDomain(InsuranceEntity e) {
        if (e == null) return null;
        Insurance i = new Insurance();
        i.setPolicyNumber(e.getPolicyNumber());
        i.setInsuranceCompany(e.getInsuranceCompany());
        i.setPolicyActive(e.isPolicyActive());
        i.setPolicyEndDate(e.getPolicyEndDate());
        i.setAnnualCopayTotal(e.getAnnualCopayTotal());
        return i;
    }

    public static InsuranceEntity toEntity(Insurance i) {
        if (i == null) return null;
        InsuranceEntity e = new InsuranceEntity();
        e.setPolicyNumber(i.getPolicyNumber());
        e.setInsuranceCompany(i.getInsuranceCompany());
        e.setPolicyActive(i.isPolicyActive());
        e.setPolicyEndDate(i.getPolicyEndDate());
        e.setAnnualCopayTotal(i.getAnnualCopayTotal());
        return e;
    }
}
