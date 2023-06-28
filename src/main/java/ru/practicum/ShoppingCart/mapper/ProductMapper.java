package ru.practicum.ShoppingCart.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.practicum.ShoppingCart.dto.ProductDTO;
import ru.practicum.ShoppingCart.model.Product;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );

    ProductDTO toDTO(Product product);

    List<ProductDTO> toDTOs(List<Product> products);

    Product toEntity(ProductDTO productDTO);
}