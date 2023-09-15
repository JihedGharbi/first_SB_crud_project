package com.fstg.mediatechs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitRequestDto {
    @NotBlank(message = "le Libelle est obligatoire de saisie")
    @Size(min=5,message = "minimum de saisie 5 caractére")
    private String libelle;
    private String reference;
    private BigDecimal prix;
    private Integer quantité;

}
