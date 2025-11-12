package app.infrastructure.adapter.in.rest.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.application.usecases.DoctorUseCase;
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
import app.infrastructure.adapter.in.rest.doctor.response.CreateDiagnosticHelpResponse;
import app.infrastructure.adapter.in.rest.doctor.response.CreateMedicalOrderResponse;
import app.infrastructure.adapter.in.rest.doctor.response.CreateMedicalRecordResponse;
import app.infrastructure.adapter.in.rest.doctor.response.PrescribeMedicineResponse;
import app.infrastructure.adapter.in.rest.doctor.response.PrescribeProcedureResponse;
import app.infrastructure.adapter.in.rest.doctor.response.UpdateMedicalRecordResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/doctor")
@PreAuthorize("hasRole('DOCTOR')")
@Validated
public class DoctorController {

    private final DoctorUseCase useCase;

    @Autowired private DoctorMapper doctorMapper;
    @Autowired private DoctorResponseMapper responseMapper;

    public DoctorController(DoctorUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/medical-records")
    public ResponseEntity<CreateMedicalRecordResponse> createMedicalRecord(@Valid @RequestBody CreateMedicalRecordRequest request) throws Exception {
        MedicalRecord record = doctorMapper.toMedicalRecord(request);
        useCase.createMedicalRecord(record);
        return new ResponseEntity<>(responseMapper.toCreateMedicalRecordResponse(record), HttpStatus.CREATED);
    }

    @PutMapping("/medical-records")
    public ResponseEntity<UpdateMedicalRecordResponse> updateMedicalRecord(@Valid @RequestBody UpdateMedicalRecordRequest request) throws Exception {
        MedicalRecord record = doctorMapper.toMedicalRecord(request);
        useCase.updateMedicalRecord(record);
        return ResponseEntity.ok(responseMapper.toUpdateMedicalRecordResponse(record));
    }

    @PostMapping("/medical-orders")
    public ResponseEntity<CreateMedicalOrderResponse> createMedicalOrder(@Valid @RequestBody CreateMedicalOrderRequest request) throws Exception {
        MedicalOrder order = doctorMapper.toMedicalOrder(request);
        useCase.createMedicalOrder(order);
        return new ResponseEntity<>(responseMapper.toCreateMedicalOrderResponse(order), HttpStatus.CREATED);
    }

    @PostMapping("/medicines")
    public ResponseEntity<PrescribeMedicineResponse> prescribeMedicine(@Valid @RequestBody PrescribeMedicineRequest request) throws Exception {
        Medicine medicine = doctorMapper.toMedicine(request);
        useCase.prescribeMedicine(medicine);
        return new ResponseEntity<>(responseMapper.toPrescribeMedicineResponse(medicine), HttpStatus.CREATED);
    }

    @PostMapping("/procedures")
    public ResponseEntity<PrescribeProcedureResponse> prescribeProcedure(@Valid @RequestBody PrescribeProcedureRequest request) throws Exception {
        Procedure procedure = doctorMapper.toProcedure(request);
        useCase.prescribeProcedure(procedure);
        return new ResponseEntity<>(responseMapper.toPrescribeProcedureResponse(procedure), HttpStatus.CREATED);
    }

    @PostMapping("/diagnostic-helps")
    public ResponseEntity<CreateDiagnosticHelpResponse> createDiagnosticHelp(@Valid @RequestBody CreateDiagnosticHelpRequest request) throws Exception {
        DiagnosticHelp dh = doctorMapper.toDiagnosticHelp(request);
        useCase.createDiagnosticHelp(dh);
        return new ResponseEntity<>(responseMapper.toCreateDiagnosticHelpResponse(dh), HttpStatus.CREATED);
    }
}
