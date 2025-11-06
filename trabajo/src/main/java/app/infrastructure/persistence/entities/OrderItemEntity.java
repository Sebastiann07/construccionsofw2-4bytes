package app.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_item")
public class OrderItemEntity {

    @Id
    @Column(name = "id", nullable = false, length = 64)
    private String id;

    @Column(name = "item_type")
    private String itemType;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "description", length = 1024)
    private String description;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "cost")
    private double cost;

    @Column(name = "total")
    private double total;

    @Column(name = "status")
    private String status;

    @Column(name = "nurse_notes", length = 1024)
    private String nurseNotes;

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getItemType() { return itemType; }
    public void setItemType(String itemType) { this.itemType = itemType; }
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getNurseNotes() { return nurseNotes; }
    public void setNurseNotes(String nurseNotes) { this.nurseNotes = nurseNotes; }
}
