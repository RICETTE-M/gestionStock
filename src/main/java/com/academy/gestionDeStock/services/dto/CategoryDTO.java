package com.academy.gestionDeStock.services.dto;



import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class CategoryDTO {

    private Long id;

    private String name;

    private String description;

    private Instant dateCreation;

    private String slug;
}
