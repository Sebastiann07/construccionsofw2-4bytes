package app.domain.services;

import app.domain.model.OrderItem;
import app.domain.ports.OrderItemPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateOrderItemStatus {

    private final OrderItemPort orderItemPort;

    public UpdateOrderItemStatus(OrderItemPort orderItemPort) {
        this.orderItemPort = orderItemPort;
    }

    public void updateStatus(String orderItemId, String status, String notes) throws Exception {
        Optional<OrderItem> optionalOrderItem = orderItemPort.findById(orderItemId);
        if (optionalOrderItem.isPresent()) {
            OrderItem orderItem = optionalOrderItem.get();
            orderItem.setStatus(status);
            orderItem.setNurseNotes(notes);
            orderItemPort.update(orderItem);
        } else {
            throw new Exception("Order item not found with ID: " + orderItemId);
        }
    }
}
