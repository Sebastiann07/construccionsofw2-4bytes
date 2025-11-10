package app.infrastructure.adapter.in.rest.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.builder.*;
import app.domain.model.*;

@Component
public class AdminMapper {

    @Autowired private PatientBuilder patientBuilder;
    @Autowired private InvoiceBuilder invoiceBuilder;
    @Autowired private EmergencyContactBuilder emergencyContactBuilder;
    @Autowired private InsuranceBuilder insuranceBuilder;
    @Autowired private VisitBuilder visitBuilder;
    @Autowired private UserBuilder userBuilder;
    @Autowired private VitalSignsBuilder vitalSignsBuilder;

    public Patient toPatient(AdminController.CreatePatientRequest req) throws Exception {
        if (req == null) throw new Exception("Solicitud inválida: paciente requerido");
        return patientBuilder.create(
                req.id,
                req.fullName,
                req.birthDate,
                req.address,
                req.phone,
                req.email,
                req.age == null ? null : Integer.valueOf(req.age),
                req.gender,
                null,
                null
        );
    }

    public Patient toPatient(AdminController.UpdatePatientRequest req) throws Exception {
        if (req == null) throw new Exception("Solicitud inválida: paciente requerido");
        return patientBuilder.create(
                req.id,
                req.fullName,
                req.birthDate,
                req.address,
                req.phone,
                req.email,
                req.age == null ? null : Integer.valueOf(req.age),
                req.gender,
                null,
                null
        );
    }

    public Invoice toInvoice(AdminController.CreateInvoiceRequest req) throws Exception {
        if (req == null) throw new Exception("Solicitud inválida: factura requerida");
        Insurance insurance = insuranceBuilder.create(
                req.insuranceCompany,
                req.policyNumber,
                req.policyActive == null ? null : Boolean.valueOf(req.policyActive),
                req.policyEndDate
        );
        return invoiceBuilder.create(
                req.invoiceNumber,
                req.patientId,
                req.doctorId,
                insurance,
                null,
                req.totalAmount == null ? null : Double.valueOf(req.totalAmount),
                req.copay == null ? null : Double.valueOf(req.copay),
                req.insurerCharge == null ? null : Double.valueOf(req.insurerCharge)
        );
    }

    public EmergencyContact toEmergencyContact(AdminController.CreateEmergencyContactRequest req) throws Exception {
        if (req == null) throw new Exception("Solicitud inválida: contacto requerido");
        return emergencyContactBuilder.create(
                req.name,
                req.phone,
                req.relation
        );
    }

    public Insurance toInsurance(AdminController.CreateInsuranceRequest req) throws Exception {
        if (req == null) throw new Exception("Solicitud inválida: seguro requerido");
        return insuranceBuilder.create(
                req.insuranceCompany,
                req.policyNumber,
                req.policyActive == null ? null : Boolean.valueOf(req.policyActive),
                req.policyEndDate
        );
    }

    public Visit toVisit(AdminController.ScheduleVisitRequest req) throws Exception {
        if (req == null) throw new Exception("Solicitud inválida: visita requerida");
        VitalSigns vital = vitalSignsBuilder.create(
                req.bloodPressure,
                req.temperature == null ? null : Double.valueOf(req.temperature),
                req.pulse == null ? null : Integer.valueOf(req.pulse),
                req.oxygenLevel == null ? null : Double.valueOf(req.oxygenLevel)
        );
        return visitBuilder.create(
                req.patientId,
                req.nurseId,
                vital
        );
    }

    public User toUser(AdminController.UpdateUserRequest req) throws Exception {
        if (req == null) throw new Exception("Solicitud inválida: usuario requerido");
        return userBuilder.create(
                req.id,
                req.fullName,
                req.birthDate,
                req.address,
                req.phone,
                req.email,
                req.age == null ? null : Integer.valueOf(req.age),
                req.username,
                req.password,
                req.role
        );
    }
}
