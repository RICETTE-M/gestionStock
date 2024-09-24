package com.academy.gestionDeStock.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "magasin")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom magasin")
    private String nameStore;

    @Column(name = "adresse")
    private String address;

    @Column(name = "telephone")
    private String phone;

    @Column(name = "caracteristiques")
    private String features;

    private String slug;

    public Store(long l, String civ, String abidjan, String s) {

    }
}
