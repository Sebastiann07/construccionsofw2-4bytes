package app.application.usecases;

import org.springframework.stereotype.Service;

import app.domain.model.MedicalRecord;
import app.domain.model.MedicalOrder;
import app.domain.model.Medicine;
import app.domain.model.Procedure;
import app.domain.services.CreateMedicalRecord;
import app.domain.services.CreateMedicalOrder;
import app.domain.services.CreateMedicine;
import app.domain.services.CreateProcedure;

@Service
public class DoctorUseCase {

    private final CreateMedicalRecord createMedicalRecord;
    private final CreateMedicalOrder createMedicalOrder;
    private final CreateMedicine createMedicine;
    private final CreateProcedure createProcedure;

    public DoctorUseCase(CreateMedicalRecord createMedicalRecord,
                         CreateMedicalOrder createMedicalOrder,
                         CreateMedicine createMedicine,
                         CreateProcedure createProcedure) {
        this.createMedicalRecord = createMedicalRecord;
        this.createMedicalOrder = createMedicalOrder;
        this.createMedicine = createMedicine;
        this.createProcedure = createProcedure;
    }

    public void createMedicalRecord(MedicalRecord record) throws Exception {
        createMedicalRecord.create(record);
    }

    public void createMedicalOrder(MedicalOrder order) throws Exception {
        createMedicalOrder.create(order);
    }

    public void prescribeMedicine(Medicine medicine) throws Exception {
        createMedicine.create(medicine);
    }

    public void prescribeProcedure(Procedure procedure) throws Exception {
        createProcedure.create(procedure);
    }
}