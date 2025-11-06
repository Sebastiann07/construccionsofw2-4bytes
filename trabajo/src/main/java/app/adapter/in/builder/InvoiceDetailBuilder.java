package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.InvoiceDetailValidator;
import app.domain.model.InvoiceDetail;
import app.domain.model.enums.DiagnosticType;

@Component
public class InvoiceDetailBuilder {

    @Autowired private InvoiceDetailValidator validator;

    public InvoiceDetail create(String diagnosticType,
                                String name,
                                Double cost,
                                String dose) throws Exception {
        DiagnosticType type = validator.typeValidator(diagnosticType);
        String n = validator.nameValidator(name);
        double c = validator.costValidator(cost);
        String d = validator.doseValidator(dose);

        InvoiceDetail detail = new InvoiceDetail();
        detail.setDiagnosticType(type);
        detail.setName(n);
        detail.setCost(c);
        detail.setDose(d);
        return detail;
    }
}
