package com.academy.gestionDeStock.web.Resources;

import com.academy.gestionDeStock.services.CategoryService;
import com.academy.gestionDeStock.services.dto.CategoryDTO;
import com.academy.gestionDeStock.services.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Slf4j
@RequiredArgsConstructor
public class CategoryResource {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @PostMapping
   public ResponseEntity<CategoryDTO> save(@RequestBody CategoryDTO category){
        log.debug("REST request to save: {}", category);
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);

    }

    @PutMapping
    public CategoryDTO update(@RequestBody CategoryDTO category, @PathVariable Long id){
        log.debug("REST request to update: {}", category);
        return categoryService.update(category, id);
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<?>findOneBySlug(@PathVariable String slug){
        log.debug("REST request to find by one slug: {}", slug);
        return new ResponseEntity<>(categoryService.findOneBySlug(slug), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>findOneById(@PathVariable Long id){
        log.debug("REST request to find one by id: {}", id);
        return new ResponseEntity<>(categoryService.findOneById(id), HttpStatus.OK);
    }

    public List<CategoryDTO> findAll() {
        log.debug("REST request to find all");
        return categoryService.findAll();
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable Long id){
        log.debug("REST request to delete by id:{}", id);
        categoryService.deleteById(id);
    }
}
