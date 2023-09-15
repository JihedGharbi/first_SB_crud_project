package com.fstg.mediatechs.controllers;

import com.fstg.mediatechs.dto.ProduitRequestDto;
import com.fstg.mediatechs.dto.ProduitResponseDto;
import com.fstg.mediatechs.models.EntityProduit;
import com.fstg.mediatechs.service.ProduitServiceImplentation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produits")
public class ProduitController {
    @Autowired
    @Qualifier("Pimpl")
    private ProduitServiceImplentation produitservice;
    public ProduitController(ProduitServiceImplentation produitservice){this.produitservice=produitservice;}

    @PostMapping("")
    public ResponseEntity<ProduitResponseDto> save(@Valid @RequestBody ProduitRequestDto produitRequestDto) {
        ProduitResponseDto produitResponseDto= produitservice.save(produitRequestDto);
        return new ResponseEntity<>(produitResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<ProduitResponseDto>> getAll() {
        return new ResponseEntity<>(produitservice.getAll(),HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
   public ResponseEntity<ProduitResponseDto> findById(@PathVariable() Integer id) {
        ProduitResponseDto produitResponseDto = produitservice.findById(id);
        return ResponseEntity.ok(produitResponseDto);
    }

    @GetMapping("/reference/{reference}")
    public ResponseEntity<ProduitResponseDto> findByreference(@PathVariable("reference") String reference) {
        ProduitResponseDto produitResponseDto= produitservice.findByreference(reference);
        return ResponseEntity.ok(produitResponseDto);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable() Integer id) {
        produitservice.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("id/{id}")
    public ResponseEntity<ProduitResponseDto> update(@RequestBody() ProduitRequestDto produitRequestDto,@PathVariable() Integer id) {
        ProduitResponseDto produitResponseDto = produitservice.update(produitRequestDto, id);
        return ResponseEntity.accepted().body(produitResponseDto);
    }
}
