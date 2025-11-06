package app.infrastructure.persistence.mapper;

import app.domain.model.OrderItem;
import app.infrastructure.persistence.entities.OrderItemEntity;

public class OrderItemMapper {

    public static OrderItem toDomain(OrderItemEntity e) {
        if (e == null) return null;
        OrderItem i = new OrderItem();
        i.setId(e.getId());
        i.setItemType(e.getItemType());
        i.setItemName(e.getItemName());
        i.setDescription(e.getDescription());
        i.setQuantity(e.getQuantity());
        i.setCost(e.getCost());
        i.setTotal(e.getTotal());
        i.setStatus(e.getStatus());
        i.setNurseNotes(e.getNurseNotes());
        return i;
    }

    public static OrderItemEntity toEntity(OrderItem i) {
        if (i == null) return null;
        OrderItemEntity e = new OrderItemEntity();
        e.setId(i.getId());
        e.setItemType(i.getItemType());
        e.setItemName(i.getItemName());
        e.setDescription(i.getDescription());
        e.setQuantity(i.getQuantity());
        e.setCost(i.getCost());
        e.setTotal(i.getTotal());
        e.setStatus(i.getStatus());
        e.setNurseNotes(i.getNurseNotes());
        return e;
    }
}
