package app.infrastructure.adapter.in.rest.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.application.usecases.AdminUseCase;
import app.domain.model.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminUseCase adminUseCase;
    private final AdminMapper mapper = new AdminMapper();

    public AdminController(AdminUseCase adminUseCase) {
        this.adminUseCase = adminUseCase;
    }

    @PostMapping("/patients")
    public ResponseEntity<CreatePatientResponse> createPatient(@RequestBody CreatePatientRequest request) throws Exception {
        Patient patient = mapper.toPatient(request);
        adminUseCase.createPatient(patient);
        return ResponseEntity.ok(new CreatePatientResponse("Paciente creado", patient));
    }

    @PutMapping("/patients")
    public ResponseEntity<UpdatePatientResponse> updatePatient(@RequestBody UpdatePatientRequest request) throws Exception {
        Patient patient = mapper.toPatient(request);
        adminUseCase.updatePatient(patient);
        return ResponseEntity.ok(new UpdatePatientResponse("Paciente actualizado", patient));
    }

    @PostMapping("/invoices")
    public ResponseEntity<CreateInvoiceResponse> createInvoice(@RequestBody CreateInvoiceRequest request) throws Exception {
        Invoice invoice = mapper.toInvoice(request);
        adminUseCase.createInvoice(invoice);
        return ResponseEntity.ok(new CreateInvoiceResponse("Factura creada", invoice));
    }

    @PostMapping("/emergency-contacts")
    public ResponseEntity<CreateEmergencyContactResponse> createEmergencyContact(@RequestBody CreateEmergencyContactRequest request) throws Exception {
        EmergencyContact contact = mapper.toEmergencyContact(request);
        adminUseCase.createEmergencyContact(contact);
        return ResponseEntity.ok(new CreateEmergencyContactResponse("Contacto de emergencia creado", contact));
    }

    @PostMapping("/insurances")
    public ResponseEntity<CreateInsuranceResponse> createInsurance(@RequestBody CreateInsuranceRequest request) throws Exception {
        Insurance insurance = mapper.toInsurance(request);
        adminUseCase.createInsurance(insurance);
        return ResponseEntity.ok(new CreateInsuranceResponse("Seguro creado", insurance));
    }

    @PostMapping("/visits")
    public ResponseEntity<ScheduleVisitResponse> scheduleVisit(@RequestBody ScheduleVisitRequest request) throws Exception {
        Visit visit = mapper.toVisit(request);
        adminUseCase.scheduleVisit(visit);
        return ResponseEntity.ok(new ScheduleVisitResponse("Visita programada", visit));
    }

    @PutMapping("/users")
    public ResponseEntity<UpdateUserResponse> updateUser(@RequestBody UpdateUserRequest request) throws Exception {
        User user = mapper.toUser(request);
        adminUseCase.updateUser(user);
        return ResponseEntity.ok(new UpdateUserResponse("Usuario actualizado", user));
    }

    // DTOs como clases internas para agrupar por rol
    public static class CreatePatientRequest { public Patient patient; }
    public static class CreatePatientResponse { public String message; public Patient patient; public CreatePatientResponse(String m, Patient p){this.message=m;this.patient=p;} }

    public static class UpdatePatientRequest { public Patient patient; }
    public static class UpdatePatientResponse { public String message; public Patient patient; public UpdatePatientResponse(String m, Patient p){this.message=m;this.patient=p;} }

    public static class CreateInvoiceRequest { public Invoice invoice; }
    public static class CreateInvoiceResponse { public String message; public Invoice invoice; public CreateInvoiceResponse(String m, Invoice i){this.message=m;this.invoice=i;} }

    public static class CreateEmergencyContactRequest { public EmergencyContact contact; }
    public static class CreateEmergencyContactResponse { public String message; public EmergencyContact contact; public CreateEmergencyContactResponse(String m, EmergencyContact c){this.message=m;this.contact=c;} }

    public static class CreateInsuranceRequest { public Insurance insurance; }
    public static class CreateInsuranceResponse { public String message; public Insurance insurance; public CreateInsuranceResponse(String m, Insurance i){this.message=m;this.insurance=i;} }

    public static class ScheduleVisitRequest { public Visit visit; }
    public static class ScheduleVisitResponse { public String message; public Visit visit; public ScheduleVisitResponse(String m, Visit v){this.message=m;this.visit=v;} }

    public static class UpdateUserRequest { public User user; }
    public static class UpdateUserResponse { public String message; public User user; public UpdateUserResponse(String m, User u){this.message=m;this.user=u;} }

}
