package com.fstg.mediatechs.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factures")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EntityFacture implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String reference;
    @Column(nullable = false , name = "date_creation")
    private Date date;

    @ManyToOne()
    private EntityClient clientel;

    @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<LigneFactureEntity> factureEntities;
}
