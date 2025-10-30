package app.domain.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.domain.model.Insurance;
import app.domain.model.Invoice;
import app.domain.model.InvoiceDetail;
import app.domain.model.Visit;
import app.domain.model.enums.DiagnosticType;

/**
 * Servicio que genera facturas a partir de una visita (Visit).
 * Usa la clase InvoiceDetail proporcionada por el modelo actual.
 */
@Service
public class BillingService {

    // Costos fijos para simplificar
    private static final double BASE_VISIT_COST = 30000.0;
    private static final double MEDICATION_COST = 15000.0;
    private static final double PROCEDURE_COST = 40000.0;
    private static final double EXAM_COST = 25000.0;

    public Invoice generateInvoiceFromVisit(Visit visit) {
        if (visit == null || visit.getPatient() == null) {
            throw new IllegalArgumentException("La visita y el paciente no pueden ser nulos");
        }

        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber("INV-" + System.currentTimeMillis());
        invoice.setPatient(visit.getPatient());
        invoice.setDoctor(visit.getNurse());
        invoice.setInsurance(visit.getPatient().getInsurance());

        List<InvoiceDetail> details = new ArrayList<>();
        double total = 0.0;

        // === Costo base por la visita ===
        InvoiceDetail baseDetail = new InvoiceDetail();
        baseDetail.setDiagnosticType(DiagnosticType.EXAM); // o DiagnosticType.VISIT si lo agregas
        baseDetail.setName("Consulta de enfermería");
        baseDetail.setCost(BASE_VISIT_COST);
        baseDetail.setDose("");
        details.add(baseDetail);
        total += baseDetail.getCost();

        // === Medicamentos administrados ===
        if (visit.getMedicationsAdministered() != null) {
            for (String med : visit.getMedicationsAdministered()) {
                InvoiceDetail d = new InvoiceDetail();
                d.setDiagnosticType(DiagnosticType.MEDICATION);
                d.setName(med);
                d.setCost(MEDICATION_COST);
                d.setDose("Según prescripción médica");
                details.add(d);
                total += d.getCost();
            }
        }

        // === Procedimientos realizados ===
        if (visit.getProceduresPerformed() != null) {
            for (String proc : visit.getProceduresPerformed()) {
                InvoiceDetail d = new InvoiceDetail();
                d.setDiagnosticType(DiagnosticType.PROCEDURE);
                d.setName(proc);
                d.setCost(PROCEDURE_COST);
                d.setDose("");
                details.add(d);
                total += d.getCost();
            }
        }

        // === Ayudas diagnósticas realizadas ===
        if (visit.getDiagnosticTests() != null) {
            for (String test : visit.getDiagnosticTests()) {
                InvoiceDetail d = new InvoiceDetail();
                d.setDiagnosticType(DiagnosticType.EXAM);
                d.setName(test);
                d.setCost(EXAM_COST);
                d.setDose("");
                details.add(d);
                total += d.getCost();
            }
        }

        // Asignar los detalles
        invoice.setDetails(details);
        invoice.setTotalAmount(total);

        // === Cálculo del copago y aseguradora ===
        Insurance insurance = visit.getPatient().getInsurance();
        double copay = 0.0;
        double insurerCharge = 0.0;

        if (insurance != null && insurance.isPolicyActive()) {
            // Supongamos que el paciente aún no superó el millón en el año
            // (más adelante esto se conectará con un repositorio)
            double copayLimit = 1_000_000.0;
            double copayFixed = 50_000.0;

            // Si no ha llegado al millón, se cobra el copago fijo
            if (insurance.getAnnualCopayTotal() < copayLimit) {
                copay = copayFixed;
                insurerCharge = total - copay;
                insurance.setAnnualCopayTotal(insurance.getAnnualCopayTotal() + copay);
            } else {
                // Ya superó el millón: aseguradora paga todo
                copay = 0.0;
                insurerCharge = total;
            }

        } else {
            // Póliza inactiva o sin seguro: paga todo el paciente
            copay = total;
            insurerCharge = 0.0;
        }

        invoice.setCopay(copay);
        invoice.setInsurerCharge(insurerCharge);

        // Como aún no hay adapters, simplemente devolvemos la factura generada
        return invoice;
    }
}
