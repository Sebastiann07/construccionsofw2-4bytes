package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.ProcedureValidator;
import app.domain.model.Procedure;

@Component
public class ProcedureBuilder {

    @Autowired private ProcedureValidator validator;

    public Procedure create(Integer orderNumber,
                            Integer itemNumber,
                            String procedureId,
                            String procedureName,
                            Integer quantity,
                            String frequency,
                            Double cost,
                            Boolean requiresSpecialist,
                            String specialistTypeId) throws Exception {

        int ord = validator.orderNumberValidator(orderNumber);
        int item = validator.itemNumberValidator(itemNumber);
        String id = validator.idValidator(procedureId);
        String name = validator.nameValidator(procedureName);
        int qty = validator.quantityValidator(quantity);
        String freq = validator.frequencyValidator(frequency);
        double c = validator.costValidator(cost);
        boolean req = validator.requiresSpecialistValidator(requiresSpecialist);
        String st = validator.specialistTypeValidator(specialistTypeId, req);

        Procedure p = new Procedure();
        p.setOrderNumber(ord);
        p.setItemNumber(item);
        p.setProcedureId(id);
        p.setProcedureName(name);
        p.setQuantity(qty);
        p.setFrequency(freq);
        p.setCost(c);
        p.setRequiresSpecialist(req);
        p.setSpecialistTypeId(st);
        return p;
    }
}
