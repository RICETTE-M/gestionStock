package com.academy.gestionDeStock.services.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {

    private Long id;

    private String name;

    private String description;

    private int price;

    private String slug;

}
