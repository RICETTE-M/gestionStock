package com.academy.gestionDeStock.web.Resources;


import com.academy.gestionDeStock.repositories.StoreRepository;
import com.academy.gestionDeStock.services.StoreService;
import com.academy.gestionDeStock.services.dto.StoreDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
@Slf4j
@RequiredArgsConstructor
public class StoreResource {

    private final StoreService storeService;
        private final StoreRepository storeRepository;

    @PostMapping
    public ResponseEntity<StoreDTO> save(@RequestBody StoreDTO store){
        log.debug("REST request to save: {}", store);
        return new ResponseEntity<>(storeService.save(store), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public StoreDTO update(@RequestBody StoreDTO store, @PathVariable Long id){
        log.debug("REST request to update: {}", store);
        return storeService.update(store, id);
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<?> getBySlug(@PathVariable String slug){
        log.debug("REST request to get by slug: {}", slug);
        return new ResponseEntity<>(storeService.findBySlug(slug),HttpStatus.OK );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        log.debug("REST request to get by id: {}", id);
        return new ResponseEntity<>(storeService.findById(id),HttpStatus.OK );
    }

    @GetMapping
    public List<StoreDTO> findAll(){
        log.debug("REST request to find all");
        return storeService.findAll();

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        log.debug("REST request to delete by id: {}", id);
        storeService.deleteById(id);
    }

}
