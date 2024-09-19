package com.academy.gestionDeStock.services;

import com.academy.gestionDeStock.models.Product;
import com.academy.gestionDeStock.repositories.ProductRepository;
import com.academy.gestionDeStock.services.dto.ProductDTO;
import com.academy.gestionDeStock.services.impl.ProductServiceImpl;
import com.academy.gestionDeStock.services.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;

    private ProductDTO productDTO;

    private ProductMapper productMapper;


//    @BeforeEach
//    public void

    @Test
    public void whenFindOneById_thenReturnProduct(){
        when(productRepository.findById(50L)).thenReturn(Optional.of(new Product(50L,"Iphone", "16 ProMax",240000, null)));
        Optional<ProductDTO> product = productService.findOneById(50L);
        assertNotNull(product, "product not null");
    }

//    public void whenSave_thenReturnProduct(){
//        when(productMapper.toEntity(productDTO)).thenReturn(product);
//        when(productRepository.save(product)).thenReturn(product);
//        ProductDTO productService.save(product);
//
//    }
}
