package com.academy.gestionDeStock.services.impl;

import com.academy.gestionDeStock.repositories.CategoryRepository;
import com.academy.gestionDeStock.services.CategoryService;
import com.academy.gestionDeStock.services.ProductService;
import com.academy.gestionDeStock.services.dto.CategoryDTO;
import com.academy.gestionDeStock.services.mapper.CategoryMapper;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class CategoryServiceImplTest {

    @MockBean
    private CategoryRepository categoryRepository;

    @MockBean
    private CategoryMapper categoryMapper;

    @MockBean
    private ProductService productService;

    @InjectMocks
    private CategoryService categoryService;

    public void whenSave_thenReturnCategoryDTO(){
        CategoryDTO categoryDTO = categoryService.save(new CategoryDTO());
    }

}
