package app.infrastructure.adapter.in.rest.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.application.usecases.AdminUseCase;
import app.application.usecases.HumanResourcesUseCase;
import app.domain.model.EmergencyContact;
import app.domain.model.Insurance;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.Visit;
import app.infrastructure.adapter.in.rest.admin.request.CreateEmergencyContactRequest;
import app.infrastructure.adapter.in.rest.admin.request.CreateInsuranceRequest;
import app.infrastructure.adapter.in.rest.admin.request.CreateInvoiceRequest;
import app.infrastructure.adapter.in.rest.admin.request.CreatePatientRequest;
import app.infrastructure.adapter.in.rest.admin.request.CreateUserRequest;
import app.infrastructure.adapter.in.rest.admin.request.ScheduleVisitRequest;
import app.infrastructure.adapter.in.rest.admin.request.UpdatePatientRequest;
import app.infrastructure.adapter.in.rest.admin.request.UpdateUserRequest;
import app.infrastructure.adapter.in.rest.admin.response.CreateEmergencyContactResponse;
import app.infrastructure.adapter.in.rest.admin.response.CreateInsuranceResponse;
import app.infrastructure.adapter.in.rest.admin.response.CreateInvoiceResponse;
import app.infrastructure.adapter.in.rest.admin.response.CreatePatientResponse;
import app.infrastructure.adapter.in.rest.admin.response.ScheduleVisitResponse;
import app.infrastructure.adapter.in.rest.admin.response.UpdatePatientResponse;
import app.infrastructure.adapter.in.rest.admin.response.UpdateUserResponse;
import app.infrastructure.adapter.in.rest.admin.response.UserResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin")
@Validated
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final AdminUseCase adminUseCase;
    private final HumanResourcesUseCase hrUseCase;
    private final AdminMapper mapper;
    private final AdminResponseMapper responseMapper;

    public AdminController(AdminUseCase adminUseCase, HumanResourcesUseCase hrUseCase, AdminMapper mapper, AdminResponseMapper responseMapper) {
        this.adminUseCase = adminUseCase;
        this.hrUseCase = hrUseCase;
        this.mapper = mapper;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/patients")
    public ResponseEntity<CreatePatientResponse> createPatient(@Valid @RequestBody CreatePatientRequest request) throws Exception {
        Patient patient = mapper.toPatient(request);
        adminUseCase.createPatient(patient);
        return ResponseEntity.ok(responseMapper.toCreatePatientResponse(patient));
    }

    @PutMapping("/patients")
    public ResponseEntity<UpdatePatientResponse> updatePatient(@Valid @RequestBody UpdatePatientRequest request) throws Exception {
        Patient patient = mapper.toPatient(request);
        adminUseCase.updatePatient(patient);
        return ResponseEntity.ok(responseMapper.toUpdatePatientResponse(patient));
    }

    @PostMapping("/invoices")
    public ResponseEntity<CreateInvoiceResponse> createInvoice(@Valid @RequestBody CreateInvoiceRequest request) throws Exception {
        Invoice invoice = mapper.toInvoice(request);
        adminUseCase.createInvoice(invoice);
        return ResponseEntity.ok(responseMapper.toCreateInvoiceResponse(invoice));
    }

    @PostMapping("/emergency-contacts")
    public ResponseEntity<CreateEmergencyContactResponse> createEmergencyContact(@Valid @RequestBody CreateEmergencyContactRequest request) throws Exception {
        EmergencyContact contact = mapper.toEmergencyContact(request);
        adminUseCase.createEmergencyContact(contact);
        return ResponseEntity.ok(responseMapper.toCreateEmergencyContactResponse(contact));
    }

    @PostMapping("/insurances")
    public ResponseEntity<CreateInsuranceResponse> createInsurance(@Valid @RequestBody CreateInsuranceRequest request) throws Exception {
        Insurance insurance = mapper.toInsurance(request);
        adminUseCase.createInsurance(insurance);
        return ResponseEntity.ok(responseMapper.toCreateInsuranceResponse(insurance));
    }

    @PostMapping("/visits")
    public ResponseEntity<ScheduleVisitResponse> scheduleVisit(@Valid @RequestBody ScheduleVisitRequest request) throws Exception {
        Visit visit = mapper.toVisit(request);
        adminUseCase.scheduleVisit(visit);
        return ResponseEntity.ok(responseMapper.toScheduleVisitResponse(visit));
    }

    @PutMapping("/users")
    public ResponseEntity<UpdateUserResponse> updateUser(@Valid @RequestBody UpdateUserRequest request) throws Exception {
        User user = mapper.toUser(request);
        adminUseCase.updateUser(user);
        return ResponseEntity.ok(responseMapper.toUpdateUserResponse(user));
    }

    // --- Endpoints para creación de usuarios por rol (alineado al ejemplo del profesor) ---
    @PostMapping("/users/doctor")
    public ResponseEntity<UserResponse> createDoctor(@Valid @RequestBody CreateUserRequest request) throws Exception {
        User user = mapper.toUser(request, "DOCTOR");
        hrUseCase.createUser(user);
        return ResponseEntity.status(201).body(responseMapper.toUserResponse(user));
    }

    @PostMapping("/users/nurse")
    public ResponseEntity<UserResponse> createNurse(@Valid @RequestBody CreateUserRequest request) throws Exception {
        User user = mapper.toUser(request, "NURSE");
        hrUseCase.createUser(user);
        return ResponseEntity.status(201).body(responseMapper.toUserResponse(user));
    }

    @PostMapping("/users/human-resources")
    public ResponseEntity<UserResponse> createHumanResources(@Valid @RequestBody CreateUserRequest request) throws Exception {
        User user = mapper.toUser(request, "HUMANRESOURCES");
        hrUseCase.createUser(user);
        return ResponseEntity.status(201).body(responseMapper.toUserResponse(user));
    }

    @PostMapping("/users/support")
    public ResponseEntity<UserResponse> createSupport(@Valid @RequestBody CreateUserRequest request) throws Exception {
        User user = mapper.toUser(request, "SUPPORT");
        hrUseCase.createUser(user);
        return ResponseEntity.status(201).body(responseMapper.toUserResponse(user));
    }

    @PostMapping("/users/admin")
    public ResponseEntity<UserResponse> createAdmin(@Valid @RequestBody CreateUserRequest request) throws Exception {
        User user = mapper.toUser(request, "ADMIN");
        hrUseCase.createUser(user);
        return ResponseEntity.status(201).body(responseMapper.toUserResponse(user));
    }

    @GetMapping("/users")
    public ResponseEntity<java.util.List<UserResponse>> listUsersByRole(@RequestParam(name = "role", required = false) String role) throws Exception {
        // TODO: Implement proper retrieval via a dedicated port/service. Currently returns 501.
        throw new UnsupportedOperationException("Listado de usuarios por rol pendiente de implementación (se requiere extensión de UserPort y adapter)");
    }
}
