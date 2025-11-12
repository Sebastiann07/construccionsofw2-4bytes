package app.infrastructure.adapter.in.rest.admin.request;

public class CreateInsuranceRequest {
    private String insuranceCompany;
    private String policyNumber;
    private String policyActive; // "true" | "false"
    private String policyEndDate;

    public CreateInsuranceRequest() {}

    public String getInsuranceCompany() { return insuranceCompany; }
    public void setInsuranceCompany(String insuranceCompany) { this.insuranceCompany = insuranceCompany; }
    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }
    public String getPolicyActive() { return policyActive; }
    public void setPolicyActive(String policyActive) { this.policyActive = policyActive; }
    public String getPolicyEndDate() { return policyEndDate; }
    public void setPolicyEndDate(String policyEndDate) { this.policyEndDate = policyEndDate; }
}
