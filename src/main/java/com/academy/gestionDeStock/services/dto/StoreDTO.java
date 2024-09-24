package com.academy.gestionDeStock.services.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StoreDTO {

    private Long id;

    private String nameStore;

    private String address;

    private String phone;

    private String features;

    private String slug;
}

