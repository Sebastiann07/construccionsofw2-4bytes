package app.infrastructure.adapter.in.rest.nurse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.application.usecases.NurseUseCase;
import app.domain.model.DiagnosticHelp;
import app.domain.model.MedicalRecord;
import app.domain.model.VitalSigns;
import app.infrastructure.adapter.in.rest.nurse.request.AddObservationRequest;
import app.infrastructure.adapter.in.rest.nurse.request.AdministerOrderItemRequest;
import app.infrastructure.adapter.in.rest.nurse.request.RecordDiagnosticHelpRequest;
import app.infrastructure.adapter.in.rest.nurse.request.RecordVitalSignsRequest;
import app.infrastructure.adapter.in.rest.nurse.response.AddObservationResponse;
import app.infrastructure.adapter.in.rest.nurse.response.AdministerOrderItemResponse;
import app.infrastructure.adapter.in.rest.nurse.response.RecordDiagnosticHelpResponse;
import app.infrastructure.adapter.in.rest.nurse.response.RecordVitalSignsResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/nurse")
@PreAuthorize("hasRole('NURSE')")
@Validated
public class NurseController {

    private final NurseUseCase useCase;

    @Autowired private NurseMapper mapper;
    @Autowired private NurseResponseMapper responseMapper;

    public NurseController(NurseUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/vital-signs")
    public ResponseEntity<RecordVitalSignsResponse> recordVitalSigns(@Valid @RequestBody RecordVitalSignsRequest request) throws Exception {
        VitalSigns vs = mapper.toVitalSigns(request);
        useCase.recordVitalSigns(Long.parseLong(request.getPatientId()), vs);
        return new ResponseEntity<>(responseMapper.toRecordVitalSignsResponse(request.getPatientId(), vs), HttpStatus.CREATED);
    }

    @PostMapping("/order-items/{id}/administer")
    public ResponseEntity<AdministerOrderItemResponse> administerOrderItem(@PathVariable("id") String id, @Valid @RequestBody AdministerOrderItemRequest request) throws Exception {
        useCase.administerOrderItem(id, request.getNotes());
        return ResponseEntity.ok(responseMapper.toAdministerOrderItemResponse(id));
    }

    @PostMapping("/diagnostic-helps")
    public ResponseEntity<RecordDiagnosticHelpResponse> recordDiagnosticHelp(@Valid @RequestBody RecordDiagnosticHelpRequest request) throws Exception {
        DiagnosticHelp dh = mapper.toDiagnosticHelp(request);
        useCase.recordDiagnosticHelp(dh);
        return new ResponseEntity<>(responseMapper.toRecordDiagnosticHelpResponse(dh), HttpStatus.CREATED);
    }

    @PutMapping("/medical-records")
    public ResponseEntity<AddObservationResponse> addObservationToMedicalRecord(@Valid @RequestBody AddObservationRequest request) throws Exception {
        MedicalRecord record = mapper.toMedicalRecord(request);
        useCase.addObservationToMedicalRecord(record);
        return ResponseEntity.ok(responseMapper.toAddObservationResponse(record));
    }
}
