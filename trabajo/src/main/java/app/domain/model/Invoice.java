package app.domain.model;

import java.util.List;

/**
 * Representa una factura generada por la atención de un paciente,
 * ya sea por una visita, procedimiento o tratamiento médico.
 * Contiene información del paciente, del médico, de la aseguradora,
 * así como el desglose de los servicios y los valores cobrados.
 */
public class Invoice {
    private String invoiceNumber;    // Identificador único de la factura
    private Patient patient;         // Paciente al que pertenece la factura
    private User doctor;             // Médico responsable de la atención
    private Insurance insurance;     // Información de la aseguradora asociada
    private List<InvoiceDetail> details; // Lista de detalles de la factura (procedimientos, medicamentos, etc.)

    // Billing data
    private double totalAmount;      // Valor total de los servicios facturados
    private double copay;            // Valor del copago que debe asumir el paciente
    private double insurerCharge;    // Valor asumido por la aseguradora

    public Invoice() {}

    // === Getters & Setters ===
    public String getInvoiceNumber() {
        return invoiceNumber;
    }
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public User getDoctor() {
        return doctor;
    }
    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public Insurance getInsurance() {
        return insurance;
    }
    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public List<InvoiceDetail> getDetails() {
        return details;
    }
    public void setDetails(List<InvoiceDetail> details) {
        this.details = details;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getCopay() {
        return copay;
    }
    public void setCopay(double copay) {
        this.copay = copay;
    }

    public double getInsurerCharge() {
        return insurerCharge;
    }
    public void setInsurerCharge(double insurerCharge) {
        this.insurerCharge = insurerCharge;
    }
}
