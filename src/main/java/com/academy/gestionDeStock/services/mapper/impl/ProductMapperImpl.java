package com.academy.gestionDeStock.services.mapper.impl;

import com.academy.gestionDeStock.models.Product;
import com.academy.gestionDeStock.services.dto.ProductDTO;
import com.academy.gestionDeStock.services.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductMapperImpl implements ProductMapper {

    private final ModelMapper modelMapper;

    @Override
    public ProductDTO fromEntity(Product entity) {
        return modelMapper.map(entity, ProductDTO.class);
    }

    @Override
    public Product toEntity(ProductDTO dto) {
        return modelMapper.map(dto, Product.class);
    }
}
