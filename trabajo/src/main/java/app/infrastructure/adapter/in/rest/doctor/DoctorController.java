package app.infrastructure.adapter.in.rest.doctor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.application.usecases.DoctorUseCase;
import app.domain.model.*;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    private final DoctorUseCase useCase;
    private final DoctorMapper mapper = new DoctorMapper();

    public DoctorController(DoctorUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/medical-records")
    public ResponseEntity<CreateMedicalRecordResponse> createMedicalRecord(@RequestBody CreateMedicalRecordRequest request) throws Exception {
        MedicalRecord record = mapper.toMedicalRecord(request);
        useCase.createMedicalRecord(record);
        return ResponseEntity.ok(new CreateMedicalRecordResponse("Historia clínica creada", record));
    }

    @PutMapping("/medical-records")
    public ResponseEntity<UpdateMedicalRecordResponse> updateMedicalRecord(@RequestBody UpdateMedicalRecordRequest request) throws Exception {
        MedicalRecord record = mapper.toMedicalRecord(request);
        useCase.updateMedicalRecord(record);
        return ResponseEntity.ok(new UpdateMedicalRecordResponse("Historia clínica actualizada", record));
    }

    @PostMapping("/medical-orders")
    public ResponseEntity<CreateMedicalOrderResponse> createMedicalOrder(@RequestBody CreateMedicalOrderRequest request) throws Exception {
        MedicalOrder order = mapper.toMedicalOrder(request);
        useCase.createMedicalOrder(order);
        return ResponseEntity.ok(new CreateMedicalOrderResponse("Orden médica creada", order));
    }

    @PostMapping("/medicines")
    public ResponseEntity<PrescribeMedicineResponse> prescribeMedicine(@RequestBody PrescribeMedicineRequest request) throws Exception {
        Medicine medicine = mapper.toMedicine(request);
        useCase.prescribeMedicine(medicine);
        return ResponseEntity.ok(new PrescribeMedicineResponse("Medicina prescrita", medicine));
    }

    @PostMapping("/procedures")
    public ResponseEntity<PrescribeProcedureResponse> prescribeProcedure(@RequestBody PrescribeProcedureRequest request) throws Exception {
        Procedure procedure = mapper.toProcedure(request);
        useCase.prescribeProcedure(procedure);
        return ResponseEntity.ok(new PrescribeProcedureResponse("Procedimiento prescrito", procedure));
    }

    @PostMapping("/diagnostic-helps")
    public ResponseEntity<CreateDiagnosticHelpResponse> createDiagnosticHelp(@RequestBody CreateDiagnosticHelpRequest request) throws Exception {
        DiagnosticHelp dh = mapper.toDiagnosticHelp(request);
        useCase.createDiagnosticHelp(dh);
        return ResponseEntity.ok(new CreateDiagnosticHelpResponse("Ayuda diagnóstica creada", dh));
    }

    public static class CreateMedicalRecordRequest { public MedicalRecord record; }
    public static class CreateMedicalRecordResponse { public String message; public MedicalRecord record; public CreateMedicalRecordResponse(String m, MedicalRecord r){this.message=m;this.record=r;} }

    public static class UpdateMedicalRecordRequest { public MedicalRecord record; }
    public static class UpdateMedicalRecordResponse { public String message; public MedicalRecord record; public UpdateMedicalRecordResponse(String m, MedicalRecord r){this.message=m;this.record=r;} }

    public static class CreateMedicalOrderRequest { public MedicalOrder order; }
    public static class CreateMedicalOrderResponse { public String message; public MedicalOrder order; public CreateMedicalOrderResponse(String m, MedicalOrder o){this.message=m;this.order=o;} }

    public static class PrescribeMedicineRequest { public Medicine medicine; }
    public static class PrescribeMedicineResponse { public String message; public Medicine medicine; public PrescribeMedicineResponse(String m, Medicine med){this.message=m;this.medicine=med;} }

    public static class PrescribeProcedureRequest { public Procedure procedure; }
    public static class PrescribeProcedureResponse { public String message; public Procedure procedure; public PrescribeProcedureResponse(String m, Procedure p){this.message=m;this.procedure=p;} }

    public static class CreateDiagnosticHelpRequest { public DiagnosticHelp diagnosticHelp; }
    public static class CreateDiagnosticHelpResponse { public String message; public DiagnosticHelp diagnosticHelp; public CreateDiagnosticHelpResponse(String m, DiagnosticHelp d){this.message=m;this.diagnosticHelp=d;} }

}
