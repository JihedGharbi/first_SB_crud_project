package com.fstg.mediatechs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitResponseDto {
    private Integer id;
    private String libelle;
    private String reference;
    private BigDecimal prix;
    private Integer quantité;
}
