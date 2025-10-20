package app.domain.model;

import java.util.List;

public class Invoice {
    private Patient Patient;
    private User doctorName;
    private Insurance insurance;
    private List<InvoiceDetail> details; 

    // Datos de cobro
    private double totalAmount;  // Total general de la factura
    private double copay;         // Valor del copago aplicado
    private double insurerCharge; // Valor asumido por la aseguradora

    public Invoice() {}

    // === Getters y Setters ===
    public Patient getPatient() {
        return Patient;
    }
    public void setPatient(Patient patient) {
        Patient = patient;
    }

        public User getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(User doctorName) {
        this.doctorName = doctorName;
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
