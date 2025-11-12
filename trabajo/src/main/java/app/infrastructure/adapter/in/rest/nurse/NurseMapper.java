package app.infrastructure.adapter.in.rest.nurse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.builder.DiagnosticHelpBuilder;
import app.adapter.in.builder.MedicalRecordBuilder;
import app.adapter.in.builder.VitalSignsBuilder;
import app.domain.model.DiagnosticHelp;
import app.domain.model.MedicalRecord;
import app.domain.model.VitalSigns;
import app.infrastructure.adapter.in.rest.nurse.request.AddObservationRequest;
import app.infrastructure.adapter.in.rest.nurse.request.RecordDiagnosticHelpRequest;
import app.infrastructure.adapter.in.rest.nurse.request.RecordVitalSignsRequest;

@Component
public class NurseMapper {

    @Autowired private VitalSignsBuilder vitalSignsBuilder;
    @Autowired private DiagnosticHelpBuilder diagnosticHelpBuilder;
    @Autowired private MedicalRecordBuilder medicalRecordBuilder;

    public VitalSigns toVitalSigns(RecordVitalSignsRequest r) throws Exception {
        Double temperature = parseDouble(r.getTemperature());
        Integer pulse = parseInteger(r.getPulse());
        Double oxygen = parseDouble(r.getOxygenLevel());
        return vitalSignsBuilder.create(r.getBloodPressure(), temperature, pulse, oxygen);
    }

    public DiagnosticHelp toDiagnosticHelp(RecordDiagnosticHelpRequest r) throws Exception {
        Integer orderNumber = parseInteger(r.getOrderNumber());
        Integer itemNumber = parseInteger(r.getItemNumber());
        Integer quantity = parseInteger(r.getQuantity());
        Double cost = parseDouble(r.getCost());
        Boolean requires = parseBoolean(r.getRequiresSpecialist());
        return diagnosticHelpBuilder.create(orderNumber, itemNumber, r.getDiagnosticId(), r.getDiagnosticName(), quantity, cost, requires, r.getSpecialistTypeId());
    }

    public MedicalRecord toMedicalRecord(AddObservationRequest r) throws Exception {
        MedicalRecord record = medicalRecordBuilder.create(r.getDoctorId(), r.getPatientId(), r.getData());
        record.setId(r.getId());
        return record;
    }

    private Integer parseInteger(String v) { if (v == null || v.isBlank()) return null; return Integer.parseInt(v.trim()); }
    private Double parseDouble(String v) { if (v == null || v.isBlank()) return null; return Double.parseDouble(v.trim()); }
    private Boolean parseBoolean(String v) { if (v == null) return null; return Boolean.parseBoolean(v.trim()); }
}
