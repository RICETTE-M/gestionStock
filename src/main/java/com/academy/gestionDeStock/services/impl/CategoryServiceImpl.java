package com.academy.gestionDeStock.services.impl;

import com.academy.gestionDeStock.models.Category;
import com.academy.gestionDeStock.repositories.CategoryRepository;
import com.academy.gestionDeStock.services.CategoryService;
import com.academy.gestionDeStock.services.dto.CategoryDTO;
import com.academy.gestionDeStock.services.mapper.CategoryMapper;
import com.academy.gestionDeStock.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        categoryDTO.setSlug(SlugifyUtils.generate(categoryDTO.getName()));
        Category category = categoryMapper.toEntity(categoryDTO);
        return categoryMapper.fromEntity(categoryRepository.save(category));    }

    @Override
    public Optional<CategoryDTO> findOneById(Long id) {
        return categoryRepository.findById(id).map(category ->{
            return categoryMapper.fromEntity(category);
        });
    }

    @Override
    public Optional<CategoryDTO>findOneBySlug(String slug) {
//        return categoryRepository.findBySlug(slug).map(categoryMapper::fromEntity);
        return null;

    }

    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll().stream().map(category -> categoryMapper.fromEntity(category)).toList();
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO, Long id) {
        return findOneById(id).map(existingCategory -> {
            existingCategory.setName(categoryDTO.getName());
            existingCategory.setDescription(categoryDTO.getDescription());
            existingCategory.setDateCreation(categoryDTO.getDateCreation());
            return save(existingCategory);
        }).orElseThrow(IllegalArgumentException::new); }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);

    }
}
