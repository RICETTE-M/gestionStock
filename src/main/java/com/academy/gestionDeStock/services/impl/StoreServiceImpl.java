package com.academy.gestionDeStock.services.impl;

import com.academy.gestionDeStock.models.Store;
import com.academy.gestionDeStock.repositories.StoreRepository;
import com.academy.gestionDeStock.services.StoreService;
import com.academy.gestionDeStock.services.dto.StoreDTO;
import com.academy.gestionDeStock.services.mapper.StoreMapper;
import com.academy.gestionDeStock.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;

    @Override
    public StoreDTO save(StoreDTO storeDTO) {
        storeDTO.setSlug(SlugifyUtils.generate(storeDTO.getNameStore()));
        Store store = storeMapper.toEntity(storeDTO);
        return storeMapper.fromEntity(storeRepository.save(store));
    }

    @Override
    public Optional<StoreDTO> findById(Long id) {
        return storeRepository.findById(id).map(store ->{
            return storeMapper.fromEntity(store);
        });
    }

    @Override
    public Optional<StoreDTO> findBySlug(String slug) {
        return storeRepository.findBySlug(slug).map(storeMapper::fromEntity);
    }

    @Override
    public StoreDTO update(StoreDTO storeDTO, Long id) {
        return findById(id).map(existingStore -> {
            existingStore.setNameStore(storeDTO.getNameStore());
            existingStore.setAddress(storeDTO.getAddress());
            existingStore.setPhone(storeDTO.getPhone());
            existingStore.setFeatures(storeDTO.getFeatures());
            return save(existingStore);
        }).orElseThrow(IllegalArgumentException::new); }



    @Override
    public List<StoreDTO> findAll() {
        return storeRepository.findAll().stream().map(store -> storeMapper.fromEntity(store)).toList();

    }

    @Override
    public void deleteById(Long id) {
        storeRepository.deleteById(id);

    }

    public Optional<StoreDTO> findOne(long l) {
                return null;
    }
}
