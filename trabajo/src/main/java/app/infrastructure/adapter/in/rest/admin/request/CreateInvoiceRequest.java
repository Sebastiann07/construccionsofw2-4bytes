package app.infrastructure.adapter.in.rest.admin.request;

public class CreateInvoiceRequest {
    private String invoiceNumber;
    private String patientId;
    private String doctorId;
    private String insuranceCompany;
    private String policyNumber;
    private String policyActive;
    private String policyEndDate;
    private String totalAmount;
    private String copay;
    private String insurerCharge;

    public CreateInvoiceRequest() {}

    public String getInvoiceNumber() { return invoiceNumber; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }
    public String getInsuranceCompany() { return insuranceCompany; }
    public void setInsuranceCompany(String insuranceCompany) { this.insuranceCompany = insuranceCompany; }
    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }
    public String getPolicyActive() { return policyActive; }
    public void setPolicyActive(String policyActive) { this.policyActive = policyActive; }
    public String getPolicyEndDate() { return policyEndDate; }
    public void setPolicyEndDate(String policyEndDate) { this.policyEndDate = policyEndDate; }
    public String getTotalAmount() { return totalAmount; }
    public void setTotalAmount(String totalAmount) { this.totalAmount = totalAmount; }
    public String getCopay() { return copay; }
    public void setCopay(String copay) { this.copay = copay; }
    public String getInsurerCharge() { return insurerCharge; }
    public void setInsurerCharge(String insurerCharge) { this.insurerCharge = insurerCharge; }
}
