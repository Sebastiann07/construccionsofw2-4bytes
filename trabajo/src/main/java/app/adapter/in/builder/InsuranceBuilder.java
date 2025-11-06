package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.InsuranceValidator;
import app.domain.model.Insurance;

@Component
public class InsuranceBuilder {

    @Autowired private InsuranceValidator validator;

    public Insurance create(String insuranceCompany, String policyNumber, Boolean policyActive, String policyEndDate) throws Exception {
        Insurance i = new Insurance();
        i.setInsuranceCompany(insuranceCompany);
        i.setPolicyNumber(policyNumber);
        i.setPolicyActive(policyActive != null ? policyActive : false);
        i.setPolicyEndDate(policyEndDate);
        validator.validate(i);
        return i;
    }
}
