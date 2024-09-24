package com.academy.gestionDeStock.services;

import com.academy.gestionDeStock.services.dto.ProductDTO;
import com.academy.gestionDeStock.services.dto.StoreDTO;

import java.util.List;
import java.util.Optional;

public interface StoreService {

    StoreDTO save(StoreDTO storeDTO);

    Optional<StoreDTO>findById(Long id);

    Optional<StoreDTO>findBySlug(String slug);


    StoreDTO update(StoreDTO storeDTO, Long id);

    List<StoreDTO>findAll();

    void deleteById(Long id);
}
