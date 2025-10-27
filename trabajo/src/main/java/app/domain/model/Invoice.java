package app.domain.model;

import java.util.List;

/**
 * Represents an invoice for a patient visit or procedure.
 * Contains details, billing breakdown, and insurance data.
 */
public class Invoice {
    private String invoiceNumber;    // Unique invoice identifier
    private Patient patient;
    private User doctor;
    private Insurance insurance;
    private List<InvoiceDetail> details; 

    // Billing data
    private double totalAmount;
    private double copay;
    private double insurerCharge;

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
