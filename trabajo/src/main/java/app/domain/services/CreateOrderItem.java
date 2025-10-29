package app.domain.services;

import org.springframework.stereotype.Service;

import app.domain.model.OrderItem;
import app.domain.ports.OrderItemPort;

/**
 * Caso de uso: agregar ítems a una orden médica.
 */
@Service
public class CreateOrderItem {

    private final OrderItemPort orderItemPort;

    public CreateOrderItem(OrderItemPort orderItemPort) {
        this.orderItemPort = orderItemPort;
    }

    public void create(OrderItem item) throws Exception {
        if (item == null) {
            throw new Exception("El ítem de orden no puede ser nulo");
        }

        if (item.getItemType() == null || item.getItemType().isEmpty()) {
            throw new Exception("Debe especificar un tipo de ítem válido");
        }

        if (item.getItemName() == null || item.getItemName().isEmpty()) {
            throw new Exception("Debe especificar un nombre de ítem válido");
        }

        if (item.getQuantity() <= 0) {
            throw new Exception("La cantidad del ítem debe ser mayor a cero");
        }

        if (item.getCost() <= 0) {
            throw new Exception("El costo del ítem debe ser mayor a cero");
        }

        item.calculateTotal();

        orderItemPort.save(item);
    }
}
