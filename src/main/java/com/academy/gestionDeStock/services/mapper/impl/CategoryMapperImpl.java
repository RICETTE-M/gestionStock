package com.academy.gestionDeStock.services.mapper.impl;

import com.academy.gestionDeStock.models.Category;
import com.academy.gestionDeStock.services.dto.CategoryDTO;
import com.academy.gestionDeStock.services.mapper.CategoryMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CategoryMapperImpl implements CategoryMapper {

    private final ModelMapper modelMapper;

    @Override
    public CategoryDTO fromEntity(Category entity) {
        return modelMapper.map(entity, CategoryDTO.class);

    }

    @Override
    public Category toEntity(CategoryDTO dto) {
        return modelMapper.map(dto, Category.class);
    }
}
