package com.academy.gestionDeStock.repositories;

import com.academy.gestionDeStock.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findBySlug(String slug);
}
