package app.domain.ports;

import app.domain.model.OrderItem;

/**
 * Puerto del dominio para los ítems de las órdenes médicas.
 */
public interface OrderItemPort {

    /**
     * Guarda un nuevo ítem dentro de una orden médica.
     */
    void save(OrderItem item) throws Exception;

    /**
     * Busca un ítem por su nombre o tipo (MEDICINE, PROCEDURE, DIAGNOSTIC_HELP).
     */
    OrderItem findByName(String name) throws Exception;
}

