package com.fstg.mediatechs.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "produits")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityProduit implements Serializable {
    @Id()
    @GeneratedValue
    private Integer id;
    @Column(name = "lib_pro", nullable = false)
    private String libelle;
    @Column(nullable = false)
    private String reference;
    @Column(nullable = false)
    private BigDecimal prix;
    @Column(nullable = false)
    private Integer quantité;

    @OneToMany(mappedBy = "produit",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<LigneFactureEntity> factureEntities;
}
