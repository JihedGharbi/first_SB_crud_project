package com.fstg.mediatechs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {
    @NotBlank(message = "le nom est obligatoire")
    @Size(min=5,max = 20 , message = "le nombre de caractères doit compris entre 5 et 20")
    private String nom;

    @NotBlank(message = "le prenom est obligatoire")
    @Size(min=5,max = 20 , message = "le nombre de caractères doit compris entre 5 et 20")
    private String prenom;
    @Pattern(regexp = "^\\d{8,11}$",message = "Format Invalid")
    private String telephone;
}
