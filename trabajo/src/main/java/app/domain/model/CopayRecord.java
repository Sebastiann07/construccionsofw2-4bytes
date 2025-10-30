package app.domain.model;

import java.time.LocalDate;

public class CopayRecord {

    private String patientId;
    private double copayAmount;
    private LocalDate date; // Fecha en que se aplicó el copago

    public CopayRecord(String patientId, double copayAmount, LocalDate date) {
        this.patientId = patientId;
        this.copayAmount = copayAmount;
        this.date = date;
    }

    public String getPatientId() {
        return patientId;
    }

    public double getCopayAmount() {
        return copayAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getYear() {
        return date.getYear();
    }
}