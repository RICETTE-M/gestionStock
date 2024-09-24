package com.academy.gestionDeStock.web.Resources;

import com.academy.gestionDeStock.services.ProductService;
import com.academy.gestionDeStock.services.dto.ProductDTO;
import com.academy.gestionDeStock.services.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Slf4j
@RequiredArgsConstructor
public class ProductResource {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO product){
        log.debug("REST request to save: {}", product);
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ProductDTO update(@RequestBody ProductDTO product, @PathVariable Long id){
        log.debug("REST request to update: {}", product);
        return productService.update(product, id);
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<?> getOneBySlug(@PathVariable String slug){
        log.debug("REST request to get one by slug: {}", slug);
        return new ResponseEntity<>(productService.findOneBySlug(slug),HttpStatus.OK );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneById(@PathVariable Long id){
        log.debug("REST request to get one by id: {}", id);
        return new ResponseEntity<>(productService.findOneById(id),HttpStatus.OK );
    }

    @GetMapping
    public List<ProductDTO> findAll(){
        log.debug("REST request to find all");
        return productService.findAll();

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        log.debug("REST request to delete by id: {}", id);
        productService.deleteById(id);
    }

}
