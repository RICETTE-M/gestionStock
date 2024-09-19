package com.academy.gestionDeStock.repositories;

import com.academy.gestionDeStock.models.Category;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    ModelMapper findBySlug(String slug);
}
