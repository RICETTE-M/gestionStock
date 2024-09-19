package com.academy.gestionDeStock.services;

import com.academy.gestionDeStock.services.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductDTO save(ProductDTO productDTO);

    List<ProductDTO> findAll();

    Optional<ProductDTO> findOneBySlug(String slug);

    Optional<ProductDTO> findOneById(Long id);


    ProductDTO update(ProductDTO productDTO, Long id);

    void deleteById(Long id);
}
