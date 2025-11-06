package app.infrastructure.adapter.in.rest.nurse;

import app.domain.model.*;

public class NurseMapper {
    public VitalSigns toVitalSigns(NurseController.RecordVitalSignsRequest req) { return req.vitalSigns; }
    public DiagnosticHelp toDiagnosticHelp(NurseController.RecordDiagnosticHelpRequest req) { return req.diagnosticHelp; }
    public MedicalRecord toMedicalRecord(NurseController.AddObservationRequest req) { return req.record; }
}
