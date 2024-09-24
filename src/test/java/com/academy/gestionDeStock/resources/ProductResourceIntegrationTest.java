package com.academy.gestionDeStock.resources;

import com.academy.gestionDeStock.services.ProductService;
import com.academy.gestionDeStock.services.dto.ProductDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductResourceIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductService productService;

    @Test
    void test(){
        ProductDTO product = new ProductDTO(1L, "Iphone","16 Pro MAX",700000,null);

        ResponseEntity<ProductDTO> response = restTemplate.postForEntity("/api/products", product, ProductDTO.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getId());
        assertEquals("16 Pro MAX", response.getBody().getName());

        ProductDTO save=productService.findOneById(response.getBody().getId()).orElse(null);
        assertNotNull(save);
        assertEquals("16 Pro MAX", save.getDescription());
    }
}
