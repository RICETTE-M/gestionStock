package com.academy.gestionDeStock.services.impl;

import com.academy.gestionDeStock.models.Store;
import com.academy.gestionDeStock.repositories.StoreRepository;
import com.academy.gestionDeStock.services.dto.StoreDTO;
import com.academy.gestionDeStock.services.impl.StoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
public class StoreServiceTest {

    @MockBean
    private StoreRepository storeRepository;

    @Autowired
    private StoreServiceImpl storeService;

    void whenFindById_thenReturnStoreNotEmpty(){

        when(storeRepository.findById(1L)).thenReturn(Optional.of(new Store(1L, "CIV", "Abidjan", "Rue 12")));
        Optional<StoreDTO> store = storeService.findOne(1L);
//        assertTrue(store.isPresent()."store is not empty");
    }
}
