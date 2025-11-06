package app.infrastructure.adapter.in.rest.doctor;

import app.domain.model.*;

public class DoctorMapper {
    public MedicalRecord toMedicalRecord(DoctorController.CreateMedicalRecordRequest req) { return req.record; }
    public MedicalRecord toMedicalRecord(DoctorController.UpdateMedicalRecordRequest req) { return req.record; }
    public MedicalOrder toMedicalOrder(DoctorController.CreateMedicalOrderRequest req) { return req.order; }
    public Medicine toMedicine(DoctorController.PrescribeMedicineRequest req) { return req.medicine; }
    public Procedure toProcedure(DoctorController.PrescribeProcedureRequest req) { return req.procedure; }
    public DiagnosticHelp toDiagnosticHelp(DoctorController.CreateDiagnosticHelpRequest req) { return req.diagnosticHelp; }
}
