package app.adapter.in.builder;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.OrderItemValidator;
import app.domain.model.OrderItem;

@Component
public class OrderItemBuilder {

    @Autowired private OrderItemValidator validator;

    public OrderItem create(String itemType,
                            String itemName,
                            String description,
                            Integer quantity,
                            Double cost,
                            String status,
                            String nurseNotes) throws Exception {

        String type = validator.typeValidator(itemType);
        String name = validator.nameValidator(itemName);
        int q = validator.quantityValidator(quantity);
        double c = validator.costValidator(cost);
        String st = validator.statusValidator(status);
        String desc = validator.text(description);
        String notes = validator.text(nurseNotes);

        OrderItem item = new OrderItem();
        item.setId(UUID.randomUUID().toString());
        item.setItemType(type);
        item.setItemName(name);
        item.setDescription(desc);
        item.setQuantity(q);
        item.setCost(c);
        item.setStatus(st);
        item.setNurseNotes(notes);
        item.calculateTotal();
        return item;
    }
}
