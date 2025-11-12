package app.infrastructure.adapter.in.rest.doctor;

import org.springframework.stereotype.Component;

import app.domain.model.DiagnosticHelp;
import app.domain.model.MedicalOrder;
import app.domain.model.MedicalRecord;
import app.domain.model.Medicine;
import app.domain.model.Procedure;
import app.infrastructure.adapter.in.rest.doctor.response.CreateDiagnosticHelpResponse;
import app.infrastructure.adapter.in.rest.doctor.response.CreateMedicalOrderResponse;
import app.infrastructure.adapter.in.rest.doctor.response.CreateMedicalRecordResponse;
import app.infrastructure.adapter.in.rest.doctor.response.PrescribeMedicineResponse;
import app.infrastructure.adapter.in.rest.doctor.response.PrescribeProcedureResponse;
import app.infrastructure.adapter.in.rest.doctor.response.UpdateMedicalRecordResponse;

@Component
public class DoctorResponseMapper {

    public CreateMedicalRecordResponse toCreateMedicalRecordResponse(MedicalRecord r) {
        return CreateMedicalRecordResponse.fromDomain(r);
    }

    public UpdateMedicalRecordResponse toUpdateMedicalRecordResponse(MedicalRecord r) {
        return UpdateMedicalRecordResponse.fromDomain(r);
    }

    public CreateMedicalOrderResponse toCreateMedicalOrderResponse(MedicalOrder o) {
        return CreateMedicalOrderResponse.fromDomain(o);
    }

    public PrescribeMedicineResponse toPrescribeMedicineResponse(Medicine m) {
        return PrescribeMedicineResponse.fromDomain(m);
    }

    public PrescribeProcedureResponse toPrescribeProcedureResponse(Procedure p) {
        return PrescribeProcedureResponse.fromDomain(p);
    }

    public CreateDiagnosticHelpResponse toCreateDiagnosticHelpResponse(DiagnosticHelp d) {
        return CreateDiagnosticHelpResponse.fromDomain(d);
    }
}
