package ru.practicum.ShoppingCart.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.practicum.ShoppingCart.dto.OrderDTO;
import ru.practicum.ShoppingCart.model.Order;

@Mapper(uses = CustomerMapper.class)
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "customerId", source = "customer.id")
    OrderDTO toDTO(Order order);

    @Mapping(target = "customer", source = "customerId")
    Order toEntity(OrderDTO orderDTO);
}
