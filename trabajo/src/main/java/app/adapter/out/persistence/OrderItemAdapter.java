package app.adapter.out.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.OrderItem;
import app.domain.ports.OrderItemPort;
import app.infrastructure.persistence.entities.OrderItemEntity;
import app.infrastructure.persistence.mapper.OrderItemMapper;
import app.infrastructure.persistence.repository.OrderItemRepository;

@Service
public class OrderItemAdapter implements OrderItemPort {

    @Autowired
    private OrderItemRepository repository;

    @Override
    public void save(OrderItem item) throws Exception {
        OrderItemEntity e = OrderItemMapper.toEntity(item);
        repository.save(e);
    }

    @Override
    public Optional<OrderItem> findById(String id) throws Exception {
        return repository.findById(id).map(OrderItemMapper::toDomain);
    }

    @Override
    public void update(OrderItem item) throws Exception {
        OrderItemEntity e = OrderItemMapper.toEntity(item);
        repository.save(e);
    }

    @Override
    public OrderItem findByName(String name) throws Exception {
        return repository.findByItemName(name).map(OrderItemMapper::toDomain).orElse(null);
    }
}
