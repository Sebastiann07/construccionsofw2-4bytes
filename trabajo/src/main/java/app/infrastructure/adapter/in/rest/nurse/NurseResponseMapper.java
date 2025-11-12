package app.infrastructure.adapter.in.rest.nurse;

import org.springframework.stereotype.Component;

import app.domain.model.DiagnosticHelp;
import app.domain.model.MedicalRecord;
import app.domain.model.VitalSigns;
import app.infrastructure.adapter.in.rest.nurse.response.AddObservationResponse;
import app.infrastructure.adapter.in.rest.nurse.response.AdministerOrderItemResponse;
import app.infrastructure.adapter.in.rest.nurse.response.RecordDiagnosticHelpResponse;
import app.infrastructure.adapter.in.rest.nurse.response.RecordVitalSignsResponse;

@Component
public class NurseResponseMapper {

    public RecordVitalSignsResponse toRecordVitalSignsResponse(String patientId, VitalSigns v) {
        return RecordVitalSignsResponse.fromDomain(patientId, v);
    }

    public AdministerOrderItemResponse toAdministerOrderItemResponse(String orderItemId) {
        AdministerOrderItemResponse r = new AdministerOrderItemResponse();
        r.setOrderItemId(orderItemId);
        r.setStatus("ADMINISTERED");
        return r;
    }

    public RecordDiagnosticHelpResponse toRecordDiagnosticHelpResponse(DiagnosticHelp d) {
        return RecordDiagnosticHelpResponse.fromDomain(d);
    }

    public AddObservationResponse toAddObservationResponse(MedicalRecord r) {
        return AddObservationResponse.fromDomain(r);
    }
}
