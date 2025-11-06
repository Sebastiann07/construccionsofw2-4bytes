package app.adapter.in.builder;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.InvoiceValidator;
import app.adapter.in.validators.PatientValidator;
import app.adapter.in.validators.UserValidator;
import app.domain.model.Insurance;
import app.domain.model.Invoice;
import app.domain.model.InvoiceDetail;
import app.domain.model.Patient;
import app.domain.model.User;

@Component
public class InvoiceBuilder {

    @Autowired private InvoiceValidator invoiceValidator;
    @Autowired private PatientValidator patientValidator;
    @Autowired private UserValidator userValidator;

    public Invoice create(String invoiceNumber,
                          String patientId,
                          String doctorId,
                          Insurance insurance,
                          List<InvoiceDetail> details,
                          Double totalAmount,
                          Double copay,
                          Double insurerCharge) throws Exception {

        String inv = invoiceValidator.invoiceNumberValidator(invoiceNumber);
        String pid = patientValidator.idValidator(patientId);
        String did = userValidator.documentValidator(doctorId);

        double total = invoiceValidator.nonNegativeAmount(totalAmount, "totalAmount");
        double c = invoiceValidator.nonNegativeAmount(copay, "copay");
        double ic = invoiceValidator.nonNegativeAmount(insurerCharge, "insurerCharge");

        Patient p = new Patient();
        try {
            p.setId(Long.parseLong(pid));
        } catch (NumberFormatException e) {
            throw new Exception("El ID del paciente debe ser numérico: " + pid, e);
        }

        User doctor = new User();
        doctor.setUsername(did);

        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber(inv == null || inv.isEmpty() ? UUID.randomUUID().toString() : inv);
        invoice.setPatient(p);
        invoice.setDoctor(doctor);
        invoice.setInsurance(insurance);
        invoice.setDetails(details);
        invoice.setTotalAmount(total);
        invoice.setCopay(c);
        invoice.setInsurerCharge(ic);
        return invoice;
    }
}
