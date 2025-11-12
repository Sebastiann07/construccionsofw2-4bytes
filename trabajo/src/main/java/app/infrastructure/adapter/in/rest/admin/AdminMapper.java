package app.infrastructure.adapter.in.rest.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.builder.EmergencyContactBuilder;
import app.adapter.in.builder.InsuranceBuilder;
import app.adapter.in.builder.InvoiceBuilder;
import app.adapter.in.builder.PatientBuilder;
import app.adapter.in.builder.UserBuilder;
import app.adapter.in.builder.VisitBuilder;
import app.adapter.in.builder.VitalSignsBuilder;
import app.domain.model.EmergencyContact;
import app.domain.model.Insurance;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.Visit;
import app.domain.model.VitalSigns;
import app.infrastructure.adapter.in.rest.admin.request.CreateEmergencyContactRequest;
import app.infrastructure.adapter.in.rest.admin.request.CreateInsuranceRequest;
import app.infrastructure.adapter.in.rest.admin.request.CreateInvoiceRequest;
import app.infrastructure.adapter.in.rest.admin.request.CreatePatientRequest;
import app.infrastructure.adapter.in.rest.admin.request.ScheduleVisitRequest;
import app.infrastructure.adapter.in.rest.admin.request.UpdatePatientRequest;
import app.infrastructure.adapter.in.rest.admin.request.UpdateUserRequest;

@Component
public class AdminMapper {

    @Autowired private PatientBuilder patientBuilder;
    @Autowired private InsuranceBuilder insuranceBuilder;
    @Autowired private EmergencyContactBuilder emergencyContactBuilder;
    @Autowired private InvoiceBuilder invoiceBuilder;
    @Autowired private VisitBuilder visitBuilder;
    @Autowired private VitalSignsBuilder vitalSignsBuilder;
    @Autowired private UserBuilder userBuilder;

    public Patient toPatient(CreatePatientRequest r) throws Exception {
        Integer age = parseInteger(r.getAge(), "age");
        return patientBuilder.create(
                r.getId(),
                r.getFullName(),
                r.getBirthDate(),
                r.getAddress(),
                r.getPhone(),
                r.getEmail(),
                age,
                r.getGender(),
                null,
                null
        );
    }

    public Patient toPatient(UpdatePatientRequest r) throws Exception {
        Integer age = parseInteger(r.getAge(), "age");
        return patientBuilder.create(
                r.getId(),
                r.getFullName(),
                r.getBirthDate(),
                r.getAddress(),
                r.getPhone(),
                r.getEmail(),
                age,
                r.getGender(),
                null,
                null
        );
    }

    public Invoice toInvoice(CreateInvoiceRequest r) throws Exception {
        Boolean active = parseBoolean(r.getPolicyActive());
        Insurance insurance = insuranceBuilder.create(
                r.getInsuranceCompany(),
                r.getPolicyNumber(),
                active,
                r.getPolicyEndDate()
        );

        Double total = parseDouble(r.getTotalAmount(), "totalAmount");
        Double copay = parseDouble(r.getCopay(), "copay");
        Double insurerCharge = parseDouble(r.getInsurerCharge(), "insurerCharge");

        return invoiceBuilder.create(
                r.getInvoiceNumber(),
                r.getPatientId(),
                r.getDoctorId(),
                insurance,
                null, // details opcional por ahora
                total,
                copay,
                insurerCharge
        );
    }

    public EmergencyContact toEmergencyContact(CreateEmergencyContactRequest r) throws Exception {
        return emergencyContactBuilder.create(r.getName(), r.getPhone(), r.getRelation());
    }

    public Insurance toInsurance(CreateInsuranceRequest r) throws Exception {
        Boolean active = parseBoolean(r.getPolicyActive());
        return insuranceBuilder.create(r.getInsuranceCompany(), r.getPolicyNumber(), active, r.getPolicyEndDate());
    }

    public Visit toVisit(ScheduleVisitRequest r) throws Exception {
        Double temperature = parseDouble(r.getTemperature(), "temperature");
        Integer pulse = parseInteger(r.getPulse(), "pulse");
        Double oxygen = parseDouble(r.getOxygenLevel(), "oxygenLevel");
        VitalSigns vs = vitalSignsBuilder.create(r.getBloodPressure(), temperature, pulse, oxygen);
        return visitBuilder.create(r.getPatientId(), r.getNurseId(), vs);
    }

    public User toUser(UpdateUserRequest r) throws Exception {
        Integer age = parseInteger(r.getAge(), "age");
        return userBuilder.create(
                r.getId(),
                r.getFullName(),
                r.getBirthDate(),
                r.getAddress(),
                r.getPhone(),
                r.getEmail(),
                age,
                r.getUsername(),
                r.getPassword(),
                r.getRole()
        );
    }

    // Create user with forced role (ADMIN, NURSE, DOCTOR, HUMANRESOURCES, SUPPORT)
    public User toUser(app.infrastructure.adapter.in.rest.admin.request.CreateUserRequest r, String roleForced) throws Exception {
        Integer age = parseInteger(r.getAge(), "age");
        return userBuilder.create(
                null,
                r.getFullName(),
                r.getBirthDate(),
                r.getAddress(),
                r.getPhone(),
                r.getEmail(),
                age,
                r.getUsername(),
                r.getPassword(),
                roleForced
        );
    }

    private Integer parseInteger(String value, String field) throws Exception {
        if (value == null || value.trim().isEmpty()) return null;
        try { return Integer.parseInt(value.trim()); } catch (NumberFormatException e) { throw new Exception("Valor inválido para " + field + ": " + value, e);}    }
    private Double parseDouble(String value, String field) throws Exception {
        if (value == null || value.trim().isEmpty()) return null;
        try { return Double.parseDouble(value.trim()); } catch (NumberFormatException e) { throw new Exception("Valor inválido para " + field + ": " + value, e);}  }
    private Boolean parseBoolean(String value) {
        if (value == null) return null;
        return Boolean.parseBoolean(value.trim());
    }
}
