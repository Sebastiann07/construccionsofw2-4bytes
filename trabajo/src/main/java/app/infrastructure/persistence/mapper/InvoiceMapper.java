package app.infrastructure.persistence.mapper;

import java.util.ArrayList;

import app.domain.model.Insurance;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.model.User;
import app.infrastructure.persistence.entities.InvoiceEntity;

public class InvoiceMapper {

    public static Invoice toDomain(InvoiceEntity e) {
        if (e == null) return null;
        Invoice inv = new Invoice();
        inv.setInvoiceNumber(e.getInvoiceNumber());
        // Map refs mínimos por ID
        if (e.getPatientId() != null) {
            Patient p = new Patient();
            p.setId(e.getPatientId());
            inv.setPatient(p);
        }
        if (e.getDoctorId() != null) {
            User u = new User();
            u.setId(e.getDoctorId());
            inv.setDoctor(u);
        }
        if (e.getInsurancePolicyNumber() != null) {
            Insurance insurance = new Insurance();
            insurance.setPolicyNumber(e.getInsurancePolicyNumber());
            inv.setInsurance(insurance);
        }
        inv.setTotalAmount(e.getTotalAmount());
        inv.setCopay(e.getCopay());
        inv.setInsurerCharge(e.getInsurerCharge());
        // details se mantiene null o vacío según preferencia
        inv.setDetails(new ArrayList<>());
        return inv;
    }

    public static InvoiceEntity toEntity(Invoice inv) {
        if (inv == null) return null;
        InvoiceEntity e = new InvoiceEntity();
        e.setInvoiceNumber(inv.getInvoiceNumber());
        e.setPatientId(inv.getPatient() != null ? inv.getPatient().getId() : null);
        e.setDoctorId(inv.getDoctor() != null ? inv.getDoctor().getId() : null);
        e.setInsurancePolicyNumber(inv.getInsurance() != null ? inv.getInsurance().getPolicyNumber() : null);
        e.setTotalAmount(inv.getTotalAmount());
        e.setCopay(inv.getCopay());
        e.setInsurerCharge(inv.getInsurerCharge());
        return e;
    }
}
