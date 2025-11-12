package app.infrastructure.adapter.in.rest.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.builder.DiagnosticHelpBuilder;
import app.adapter.in.builder.MedicalOrderBuilder;
import app.adapter.in.builder.MedicalRecordBuilder;
import app.adapter.in.builder.MedicineBuilder;
import app.adapter.in.builder.ProcedureBuilder;
import app.domain.model.DiagnosticHelp;
import app.domain.model.MedicalOrder;
import app.domain.model.MedicalRecord;
import app.domain.model.Medicine;
import app.domain.model.Procedure;
import app.infrastructure.adapter.in.rest.doctor.request.CreateDiagnosticHelpRequest;
import app.infrastructure.adapter.in.rest.doctor.request.CreateMedicalOrderRequest;
import app.infrastructure.adapter.in.rest.doctor.request.CreateMedicalRecordRequest;
import app.infrastructure.adapter.in.rest.doctor.request.PrescribeMedicineRequest;
import app.infrastructure.adapter.in.rest.doctor.request.PrescribeProcedureRequest;
import app.infrastructure.adapter.in.rest.doctor.request.UpdateMedicalRecordRequest;

@Component
public class DoctorMapper {

    @Autowired private MedicalRecordBuilder medicalRecordBuilder;
    @Autowired private MedicalOrderBuilder medicalOrderBuilder;
    @Autowired private MedicineBuilder medicineBuilder;
    @Autowired private ProcedureBuilder procedureBuilder;
    @Autowired private DiagnosticHelpBuilder diagnosticHelpBuilder;

    public MedicalRecord toMedicalRecord(CreateMedicalRecordRequest r) throws Exception {
        return medicalRecordBuilder.create(r.getDoctorId(), r.getPatientId(), r.getData());
    }

    public MedicalRecord toMedicalRecord(UpdateMedicalRecordRequest r) throws Exception {
        // For update we pass the new data; builder generates id but we need to set provided id
        MedicalRecord rec = medicalRecordBuilder.create(r.getDoctorId(), r.getPatientId(), r.getData());
        rec.setId(r.getId());
        return rec;
    }

    public MedicalOrder toMedicalOrder(CreateMedicalOrderRequest r) throws Exception {
        return medicalOrderBuilder.create(r.getDoctorId(), r.getPatientId(), r.getDate(), r.getObservations());
    }

    public Medicine toMedicine(PrescribeMedicineRequest r) throws Exception {
        Integer orderNumber = parseInteger(r.getOrderNumber());
        Integer itemNumber = parseInteger(r.getItemNumber());
        Double cost = parseDouble(r.getCost());
        return medicineBuilder.create(
                r.getMedicineId(),
                r.getMedicineName(),
                orderNumber,
                itemNumber,
                r.getDose(),
                r.getTreatmentDuration(),
                cost
        );
    }

    public Procedure toProcedure(PrescribeProcedureRequest r) throws Exception {
        Integer orderNumber = parseInteger(r.getOrderNumber());
        Integer itemNumber = parseInteger(r.getItemNumber());
        Integer quantity = parseInteger(r.getQuantity());
        Double cost = parseDouble(r.getCost());
        Boolean requires = parseBoolean(r.getRequiresSpecialist());
        return procedureBuilder.create(
                orderNumber,
                itemNumber,
                r.getProcedureId(),
                r.getProcedureName(),
                quantity,
                r.getFrequency(),
                cost,
                requires,
                r.getSpecialistTypeId()
        );
    }

    public DiagnosticHelp toDiagnosticHelp(CreateDiagnosticHelpRequest r) throws Exception {
        Integer orderNumber = parseInteger(r.getOrderNumber());
        Integer itemNumber = parseInteger(r.getItemNumber());
        Integer quantity = parseInteger(r.getQuantity());
        Double cost = parseDouble(r.getCost());
        Boolean requires = parseBoolean(r.getRequiresSpecialist());
        return diagnosticHelpBuilder.create(
                orderNumber,
                itemNumber,
                r.getDiagnosticId(),
                r.getDiagnosticName(),
                quantity,
                cost,
                requires,
                r.getSpecialistTypeId()
        );
    }

    private Integer parseInteger(String v) { if (v == null || v.isBlank()) return null; return Integer.parseInt(v.trim()); }
    private Double parseDouble(String v) { if (v == null || v.isBlank()) return null; return Double.parseDouble(v.trim()); }
    private Boolean parseBoolean(String v) { if (v == null) return null; return Boolean.parseBoolean(v.trim()); }
}
