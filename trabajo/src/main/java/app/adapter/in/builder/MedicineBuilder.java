package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.MedicineValidator;
import app.domain.model.Medicine;

@Component
public class MedicineBuilder {

    @Autowired private MedicineValidator validator;

    public Medicine create(String medicineId,
                           String medicineName,
                           Integer orderNumber,
                           Integer itemNumber,
                           String dose,
                           String treatmentDuration,
                           Double cost) throws Exception {

        String id = validator.idValidator(medicineId);
        String name = validator.nameValidator(medicineName);
        int ord = validator.orderNumberValidator(orderNumber);
        int item = validator.itemNumberValidator(itemNumber);
        String d = validator.doseValidator(dose);
        String dur = validator.treatmentDurationValidator(treatmentDuration);
        double c = validator.costValidator(cost);

        Medicine m = new Medicine();
        m.setMedicineId(id);
        m.setMedicineName(name);
        m.setOrderNumber(ord);
        m.setItemNumber(item);
        m.setDose(d);
        m.setTreatmentDuration(dur);
        m.setCost(c);
        return m;
    }
}
