package com.academy.gestionDeStock.services;

import com.academy.gestionDeStock.services.dto.CategoryDTO;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    CategoryDTO save(CategoryDTO categoryDTO);

    Optional<CategoryDTO>findOneById(Long id);

    Optional<CategoryDTO>findOneBySlug(String slug);

    List<CategoryDTO> findAll();

    CategoryDTO update(CategoryDTO categoryDTO, Long id);

    void deleteById(Long id);



}
