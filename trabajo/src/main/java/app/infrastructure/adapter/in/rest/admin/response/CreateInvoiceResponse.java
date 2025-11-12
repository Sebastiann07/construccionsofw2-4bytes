package app.infrastructure.adapter.in.rest.admin.response;

public class CreateInvoiceResponse {
    private String invoiceNumber;
    private long patientId;
    private String doctorUsername;
    private double totalAmount;
    private double copay;
    private double insurerCharge;

    public String getInvoiceNumber() { return invoiceNumber; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }
    public long getPatientId() { return patientId; }
    public void setPatientId(long patientId) { this.patientId = patientId; }
    public String getDoctorUsername() { return doctorUsername; }
    public void setDoctorUsername(String doctorUsername) { this.doctorUsername = doctorUsername; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public double getCopay() { return copay; }
    public void setCopay(double copay) { this.copay = copay; }
    public double getInsurerCharge() { return insurerCharge; }
    public void setInsurerCharge(double insurerCharge) { this.insurerCharge = insurerCharge; }
}
