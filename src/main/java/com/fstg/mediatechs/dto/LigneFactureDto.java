package com.fstg.mediatechs.dto;

import com.fstg.mediatechs.models.EntityFacture;
import com.fstg.mediatechs.models.EntityProduit;
import com.fstg.mediatechs.models.LigneFactureKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LigneFactureDto {
    private LigneFactureKey id;
    private EntityFacture facture;
    private EntityProduit produit;
}
