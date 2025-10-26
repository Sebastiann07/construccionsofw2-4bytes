package app.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedicalOrder {

    private long id;                        // Número de orden (6 dígitos máximo)
    private Patient patient;                // Paciente al que pertenece la orden
    private User doctor;                    // Doctor que emite la orden
    private LocalDate date;                 // Fecha de creación de la orden

    private List<OrderItem> items;   // Ítems clínicos asociados (med., proc., exámenes)

    public MedicalOrder() {
        this.items = new ArrayList<>();
        this.date = LocalDate.now();
    }

    // ==== Getters y Setters ====
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<OrderItem> getItems() {
        return items;
    }
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    // Helper para agregar ítems individualmente
    public void addItem(OrderItem item) {
        this.items.add(item);
    }

}