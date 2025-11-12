package app.infrastructure.adapter.in.rest.admin.response;

public class CreateInsuranceResponse {
    private String insuranceCompany;
    private String policyNumber;
    private boolean policyActive;
    private String policyEndDate;

    public String getInsuranceCompany() { return insuranceCompany; }
    public void setInsuranceCompany(String insuranceCompany) { this.insuranceCompany = insuranceCompany; }
    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }
    public boolean isPolicyActive() { return policyActive; }
    public void setPolicyActive(boolean policyActive) { this.policyActive = policyActive; }
    public String getPolicyEndDate() { return policyEndDate; }
    public void setPolicyEndDate(String policyEndDate) { this.policyEndDate = policyEndDate; }
}
