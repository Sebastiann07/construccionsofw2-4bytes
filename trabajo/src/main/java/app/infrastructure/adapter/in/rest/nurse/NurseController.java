package app.infrastructure.adapter.in.rest.nurse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.application.usecases.NurseUseCase;
import app.domain.model.*;

@RestController
@RequestMapping("/api/nurse")
public class NurseController {

    private final NurseUseCase useCase;
    private final NurseMapper mapper = new NurseMapper();

    public NurseController(NurseUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/vital-signs")
    public ResponseEntity<RecordVitalSignsResponse> recordVitalSigns(@RequestBody RecordVitalSignsRequest request) throws Exception {
        VitalSigns vs = mapper.toVitalSigns(request);
        useCase.recordVitalSigns(request.patientId, vs);
        return ResponseEntity.ok(new RecordVitalSignsResponse("Signos vitales registrados", vs));
    }

    @PostMapping("/order-items/{id}/administer")
    public ResponseEntity<AdministerOrderItemResponse> administerOrderItem(@PathVariable("id") String id, @RequestBody AdministerOrderItemRequest request) throws Exception {
        useCase.administerOrderItem(id, request.notes);
        return ResponseEntity.ok(new AdministerOrderItemResponse("Ítem administrado", id));
    }

    @PostMapping("/diagnostic-helps")
    public ResponseEntity<RecordDiagnosticHelpResponse> recordDiagnosticHelp(@RequestBody RecordDiagnosticHelpRequest request) throws Exception {
        DiagnosticHelp dh = mapper.toDiagnosticHelp(request);
        useCase.recordDiagnosticHelp(dh);
        return ResponseEntity.ok(new RecordDiagnosticHelpResponse("Ayuda diagnóstica registrada", dh));
    }

    @PutMapping("/medical-records")
    public ResponseEntity<AddObservationResponse> addObservationToMedicalRecord(@RequestBody AddObservationRequest request) throws Exception {
        MedicalRecord record = mapper.toMedicalRecord(request);
        useCase.addObservationToMedicalRecord(record);
        return ResponseEntity.ok(new AddObservationResponse("Observación añadida", record));
    }

    public static class RecordVitalSignsRequest { public long patientId; public VitalSigns vitalSigns; }
    public static class RecordVitalSignsResponse { public String message; public VitalSigns vitalSigns; public RecordVitalSignsResponse(String m, VitalSigns v){this.message=m;this.vitalSigns=v;} }

    public static class AdministerOrderItemRequest { public String notes; }
    public static class AdministerOrderItemResponse { public String message; public String orderItemId; public AdministerOrderItemResponse(String m, String id){this.message=m;this.orderItemId=id;} }

    public static class RecordDiagnosticHelpRequest { public DiagnosticHelp diagnosticHelp; }
    public static class RecordDiagnosticHelpResponse { public String message; public DiagnosticHelp diagnosticHelp; public RecordDiagnosticHelpResponse(String m, DiagnosticHelp d){this.message=m;this.diagnosticHelp=d;} }

    public static class AddObservationRequest { public MedicalRecord record; }
    public static class AddObservationResponse { public String message; public MedicalRecord record; public AddObservationResponse(String m, MedicalRecord r){this.message=m;this.record=r;} }

}
