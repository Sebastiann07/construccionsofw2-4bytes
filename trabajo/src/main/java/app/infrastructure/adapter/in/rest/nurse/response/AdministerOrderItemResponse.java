package app.infrastructure.adapter.in.rest.nurse.response;

public class AdministerOrderItemResponse {
    private String orderItemId;
    private String status;

    public String getOrderItemId() { return orderItemId; }
    public void setOrderItemId(String orderItemId) { this.orderItemId = orderItemId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
