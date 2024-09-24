package com.academy.gestionDeStock.services.mapper.impl;

import com.academy.gestionDeStock.models.Store;
import com.academy.gestionDeStock.services.dto.ProductDTO;
import com.academy.gestionDeStock.services.dto.StoreDTO;
import com.academy.gestionDeStock.services.mapper.StoreMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StoreMapperImpl implements StoreMapper {

    private final ModelMapper modelMapper;

    @Override
    public StoreDTO fromEntity(Store entity) {
        return modelMapper.map(entity, StoreDTO.class);
    }

    @Override
    public Store toEntity(StoreDTO dto) {
        return modelMapper.map(dto, Store.class);
    }
}
