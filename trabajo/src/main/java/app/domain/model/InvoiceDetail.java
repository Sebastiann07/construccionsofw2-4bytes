package app.domain.model;

import app.domain.model.enums.DiagnosticType;

public class InvoiceDetail {

    private DiagnosticType diagnosticType;  // Tipo de diagnóstico (medicamento, procedimiento, examen)
    private String name;                    // Nombre del medicamento, procedimiento o examen
    private double cost;                    // Costo individual
    private String dose;                    // Solo aplica para medicamentos (puede quedar vacío en otros casos)

    public InvoiceDetail() {}

    // === Getters y Setters ===
    public DiagnosticType getDiagnosticType() {
        return diagnosticType;
    }
    public void setDiagnosticType(DiagnosticType diagnosticType) {
        this.diagnosticType = diagnosticType;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDose() {
        return dose;
    }
    public void setDose(String dose) {
        this.dose = dose;
    }
}