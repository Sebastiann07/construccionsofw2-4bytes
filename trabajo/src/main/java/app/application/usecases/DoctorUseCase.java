package app.application.usecases;

import org.springframework.stereotype.Service;

import app.domain.model.DiagnosticHelp;
import app.domain.model.MedicalRecord;
import app.domain.model.MedicalOrder;
import app.domain.model.Medicine;
import app.domain.model.Procedure;
import app.domain.model.VitalSigns;
import app.domain.services.CreateDiagnosticHelp;
import app.domain.services.CreateMedicalRecord;
import app.domain.services.CreateMedicalOrder;
import app.domain.services.CreateMedicine;
import app.domain.services.CreateProcedure;
import app.domain.services.CreateVitalSigns;
import app.domain.services.UpdateMedicalRecord;

@Service
public class DoctorUseCase {

    private final CreateMedicalRecord createMedicalRecord;
    private final UpdateMedicalRecord updateMedicalRecord;
    private final CreateMedicalOrder createMedicalOrder;
    private final CreateMedicine createMedicine;
    private final CreateProcedure createProcedure;
    private final CreateDiagnosticHelp createDiagnosticHelp;

    public DoctorUseCase(CreateMedicalRecord createMedicalRecord,
                         UpdateMedicalRecord updateMedicalRecord,
                         CreateMedicalOrder createMedicalOrder,
                         CreateMedicine createMedicine,
                         CreateProcedure createProcedure,
                         CreateDiagnosticHelp createDiagnosticHelp) {
        this.createMedicalRecord = createMedicalRecord;
        this.updateMedicalRecord = updateMedicalRecord;
        this.createMedicalOrder = createMedicalOrder;
        this.createMedicine = createMedicine;
        this.createProcedure = createProcedure;
        this.createDiagnosticHelp = createDiagnosticHelp;
    }

    public void createMedicalRecord(MedicalRecord record) throws Exception {
        createMedicalRecord.create(record);
    }

    public void updateMedicalRecord(MedicalRecord record) throws Exception {
        updateMedicalRecord.update(record);
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

    public void createDiagnosticHelp(DiagnosticHelp diagnosticHelp) throws Exception {
        createDiagnosticHelp.create(diagnosticHelp);
    }

}