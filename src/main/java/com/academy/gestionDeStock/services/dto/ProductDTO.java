package com.academy.gestionDeStock.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private Long id;

    private String name;

    private String description;

    private int price;

    private String slug;

}
