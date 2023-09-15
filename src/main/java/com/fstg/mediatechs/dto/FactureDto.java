package com.fstg.mediatechs.dto;

import com.fstg.mediatechs.models.LigneFactureEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactureDto {
    private Integer id;
    private String reference;
    private Date date;
    private List<LigneFactureEntity> factureEntities;
}
