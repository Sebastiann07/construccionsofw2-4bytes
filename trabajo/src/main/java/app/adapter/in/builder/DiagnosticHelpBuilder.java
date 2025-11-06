package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.DiagnosticHelpValidator;
import app.domain.model.DiagnosticHelp;

@Component
public class DiagnosticHelpBuilder {

    @Autowired private DiagnosticHelpValidator validator;

    public DiagnosticHelp create(Integer orderNumber,
                                 Integer itemNumber,
                                 String diagnosticId,
                                 String diagnosticName,
                                 Integer quantity,
                                 Double cost,
                                 Boolean requiresSpecialist,
                                 String specialistTypeId) throws Exception {

        int ord = validator.orderNumberValidator(orderNumber);
        int item = validator.itemNumberValidator(itemNumber);
        String id = validator.idValidator(diagnosticId);
        String name = validator.nameValidator(diagnosticName);
        int qty = validator.quantityValidator(quantity);
        double c = validator.costValidator(cost);
        boolean req = validator.requiresSpecialistValidator(requiresSpecialist);
        String st = validator.specialistTypeValidator(specialistTypeId, req);

        DiagnosticHelp d = new DiagnosticHelp();
        d.setOrderNumber(ord);
        d.setItemNumber(item);
        d.setDiagnosticId(id);
        d.setDiagnosticName(name);
        d.setQuantity(qty);
        d.setCost(c);
        d.setRequiresSpecialist(req);
        d.setSpecialistTypeId(st);
        return d;
    }
}
