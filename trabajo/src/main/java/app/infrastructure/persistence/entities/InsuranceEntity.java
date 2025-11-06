package app.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "insurance")
public class InsuranceEntity {

    @Id
    @Column(name = "policy_number", nullable = false, length = 64)
    private String policyNumber;

    @Column(name = "insurance_company")
    private String insuranceCompany;

    @Column(name = "policy_active")
    private boolean policyActive;

    @Column(name = "policy_end_date")
    private String policyEndDate;

    @Column(name = "annual_copay_total")
    private double annualCopayTotal;

    // Getters y Setters
    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }
    public String getInsuranceCompany() { return insuranceCompany; }
    public void setInsuranceCompany(String insuranceCompany) { this.insuranceCompany = insuranceCompany; }
    public boolean isPolicyActive() { return policyActive; }
    public void setPolicyActive(boolean policyActive) { this.policyActive = policyActive; }
    public String getPolicyEndDate() { return policyEndDate; }
    public void setPolicyEndDate(String policyEndDate) { this.policyEndDate = policyEndDate; }
    public double getAnnualCopayTotal() { return annualCopayTotal; }
    public void setAnnualCopayTotal(double annualCopayTotal) { this.annualCopayTotal = annualCopayTotal; }
}
