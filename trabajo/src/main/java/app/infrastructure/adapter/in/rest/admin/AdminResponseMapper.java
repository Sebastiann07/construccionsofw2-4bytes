package app.infrastructure.adapter.in.rest.admin;

import org.springframework.stereotype.Component;

import app.domain.model.EmergencyContact;
import app.domain.model.Insurance;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.Visit;
import app.infrastructure.adapter.in.rest.admin.response.CreateEmergencyContactResponse;
import app.infrastructure.adapter.in.rest.admin.response.CreateInsuranceResponse;
import app.infrastructure.adapter.in.rest.admin.response.CreateInvoiceResponse;
import app.infrastructure.adapter.in.rest.admin.response.CreatePatientResponse;
import app.infrastructure.adapter.in.rest.admin.response.ScheduleVisitResponse;
import app.infrastructure.adapter.in.rest.admin.response.UpdatePatientResponse;
import app.infrastructure.adapter.in.rest.admin.response.UpdateUserResponse;
import app.infrastructure.adapter.in.rest.admin.response.UserResponse;
import java.time.format.DateTimeFormatter;

@Component
public class AdminResponseMapper {

    public CreatePatientResponse toCreatePatientResponse(Patient p) {
        CreatePatientResponse r = new CreatePatientResponse();
        r.setId(p.getId());
        r.setFullName(p.getFullName());
        r.setEmail(p.getEmail());
        r.setPhone(p.getPhone());
        r.setGender(p.getGender() == null ? null : p.getGender().name());
        return r;
    }

    public UpdatePatientResponse toUpdatePatientResponse(Patient p) {
        UpdatePatientResponse r = new UpdatePatientResponse();
        r.setId(p.getId());
        r.setFullName(p.getFullName());
        r.setEmail(p.getEmail());
        r.setPhone(p.getPhone());
        r.setGender(p.getGender() == null ? null : p.getGender().name());
        return r;
    }

    public CreateInvoiceResponse toCreateInvoiceResponse(Invoice i) {
        CreateInvoiceResponse r = new CreateInvoiceResponse();
        r.setInvoiceNumber(i.getInvoiceNumber());
        r.setPatientId(i.getPatient() == null ? 0 : i.getPatient().getId());
        r.setDoctorUsername(i.getDoctor() == null ? null : i.getDoctor().getUsername());
        r.setTotalAmount(i.getTotalAmount());
        r.setCopay(i.getCopay());
        r.setInsurerCharge(i.getInsurerCharge());
        return r;
    }

    public CreateEmergencyContactResponse toCreateEmergencyContactResponse(EmergencyContact c) {
        CreateEmergencyContactResponse r = new CreateEmergencyContactResponse();
        r.setName(c.getEmergencyContactName());
        r.setPhone(c.getEmergencyContactPhone());
        r.setRelation(c.getEmergencyContactRelation());
        return r;
    }

    public CreateInsuranceResponse toCreateInsuranceResponse(Insurance ins) {
        CreateInsuranceResponse r = new CreateInsuranceResponse();
        r.setInsuranceCompany(ins.getInsuranceCompany());
        r.setPolicyNumber(ins.getPolicyNumber());
        r.setPolicyActive(ins.isPolicyActive());
        r.setPolicyEndDate(ins.getPolicyEndDate());
        return r;
    }

    public ScheduleVisitResponse toScheduleVisitResponse(Visit v) {
        ScheduleVisitResponse r = new ScheduleVisitResponse();
        r.setVisitId(v.getVisitId());
        r.setPatientId(v.getPatient() == null ? 0 : v.getPatient().getId());
        r.setNurseId(v.getNurse() == null ? 0 : v.getNurse().getId());
        if (v.getVitalSigns() != null) {
            r.setBloodPressure(v.getVitalSigns().getBloodPressure());
            r.setTemperature(v.getVitalSigns().getTemperature());
            r.setPulse(v.getVitalSigns().getPulse());
            r.setOxygenLevel(v.getVitalSigns().getOxygenLevel());
        }
        if (v.getVisitDate() != null) {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            r.setVisitDate(v.getVisitDate().format(fmt));
        } else {
            r.setVisitDate(null);
        }
        return r;
    }

    public UpdateUserResponse toUpdateUserResponse(User u) {
        UpdateUserResponse r = new UpdateUserResponse();
        r.setId(u.getId());
        r.setUsername(u.getUsername());
        r.setRole(u.getRole() == null ? null : u.getRole().name());
        r.setFullName(u.getFullName());
        r.setEmail(u.getEmail());
        r.setPhone(u.getPhone());
        return r;
    }

    public UserResponse toUserResponse(User u) {
        UserResponse r = new UserResponse();
        r.setId(u.getId());
        r.setUsername(u.getUsername());
        r.setRole(u.getRole() == null ? null : u.getRole().name());
        r.setFullName(u.getFullName());
        r.setEmail(u.getEmail());
        r.setPhone(u.getPhone());
        return r;
    }
}
