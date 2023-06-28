package ru.practicum.ShoppingCart.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.practicum.ShoppingCart.dto.OrderDetailDTO;
import ru.practicum.ShoppingCart.dto.ProductDTO;
import ru.practicum.ShoppingCart.model.OrderDetail;
import ru.practicum.ShoppingCart.model.Product;

import java.util.List;

@Mapper
public interface OrderDetailMapper {

    OrderDetailMapper INSTANCE = Mappers.getMapper( OrderDetailMapper.class );

    @Mapping(target = "orderId", source = "order.id")
    @Mapping(target = "productId", source = "product.id")
    OrderDetailDTO toDTO(OrderDetail orderDetail);

    @Mapping(target = "order.id", source = "orderId")
    @Mapping(target = "product.id", source = "productId")
    OrderDetail toEntity(OrderDetailDTO orderDetailDTO);

    List<OrderDetailDTO> toDTOs(List<OrderDetail> orderDetails);
}