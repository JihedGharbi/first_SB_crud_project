package com.fstg.mediatechs.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityClient implements Serializable {
    @Id()
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(name = "telephone_client")
    private String telephone;
    @OneToMany(mappedBy = "clientel",cascade = CascadeType.ALL,fetch = FetchType.LAZY)

    private List<EntityFacture> factures;
}
