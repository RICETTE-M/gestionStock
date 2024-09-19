package com.academy.gestionDeStock.services.impl;

import com.academy.gestionDeStock.models.Product;
import com.academy.gestionDeStock.repositories.ProductRepository;
import com.academy.gestionDeStock.services.ProductService;
import com.academy.gestionDeStock.services.dto.ProductDTO;
import com.academy.gestionDeStock.services.mapper.ProductMapper;
import com.academy.gestionDeStock.utils.SlugifyUtils;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Optional<ProductDTO> findOneById(Long id) {
        return productRepository.findById(id).map(product ->{
            return productMapper.fromEntity(product);
        });

    }

    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream().map(product -> productMapper.fromEntity(product)).toList();
    }


    @Override
    public ProductDTO save(ProductDTO productDTO) {
            productDTO.setSlug(SlugifyUtils.generate(productDTO.getName()));
        Product product = productMapper.toEntity(productDTO);
        return productMapper.fromEntity(productRepository.save(product));
    }

    @Override
    public Optional<ProductDTO> findOneBySlug(String slug) {
        return productRepository.findBySlug(slug).map(productMapper::fromEntity);

    }

    @Override
    public ProductDTO update(ProductDTO productDTO, Long id) {
        return findOneById(id).map(existingProduct -> {
            existingProduct.setPrice(productDTO.getPrice());
            existingProduct.setDescription(productDTO.getDescription());
            existingProduct.setName(productDTO.getName());
            return save(existingProduct);
        }).orElseThrow(IllegalArgumentException::new); }


    @Override
    public void deleteById(Long id) {
         productRepository.deleteById(id);

    }
}
