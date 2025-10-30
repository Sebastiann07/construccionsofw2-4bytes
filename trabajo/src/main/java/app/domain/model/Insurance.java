package app.domain.model;

public class Insurance {

    private String insuranceCompany;   // Nombre de la compañía de seguros
    private String policyNumber;       // Número de póliza del paciente
    private boolean policyActive;      // Estado de la póliza (true = activa, false = inactiva)
    private String policyEndDate;      // Fecha de finalización de la póliza (dd/mm/yyyy)

    public Insurance() {}  // Constructor vacío 

    // === Getters y Setters ===
    public String getInsuranceCompany() {
        return insuranceCompany;
    }
    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public boolean isPolicyActive() {
        return policyActive;
    }
    public void setPolicyActive(boolean policyActive) {
        this.policyActive = policyActive;
    }

    public String getPolicyEndDate() {
        return policyEndDate;
    }
    public void setPolicyEndDate(String policyEndDate) {
        this.policyEndDate = policyEndDate;
    }
    private double annualCopayTotal = 0.0;

    public double getAnnualCopayTotal() {
        return annualCopayTotal;
    }

    public void setAnnualCopayTotal(double annualCopayTotal) {
        this.annualCopayTotal = annualCopayTotal;
}

}