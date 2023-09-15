package com.fstg.mediatechs.service;

import com.fstg.mediatechs.dao.ProduitDao;
import com.fstg.mediatechs.dto.ProduitRequestDto;
import com.fstg.mediatechs.dto.ProduitResponseDto;
import com.fstg.mediatechs.exceptions.EntityNotFoundException;
import com.fstg.mediatechs.models.EntityProduit;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("Pimpl")
public class ProduitServiceImplentation {
    private ProduitDao produitDao;
    private ModelMapper modelMapper;
    public ProduitServiceImplentation(ModelMapper modelMapper,ProduitDao produitDao){
        this.produitDao=produitDao;
        this.modelMapper=modelMapper;
    }
    public ProduitResponseDto save(ProduitRequestDto produitRequestDto){
        EntityProduit entityProduit=modelMapper.map(produitRequestDto,EntityProduit.class);
        EntityProduit saved=produitDao.save(entityProduit);
        return modelMapper.map(saved,ProduitResponseDto.class);
    }

    public List<ProduitResponseDto>getAll(){
        return produitDao.findAll().stream().map(el->modelMapper.map(el,ProduitResponseDto.class)).collect(Collectors.toList());
    }

    public ProduitResponseDto findById(Integer id){
        EntityProduit entityProduit=produitDao.findById(id).orElseThrow(()->new EntityNotFoundException("Produit Not Found"));
        return modelMapper.map(entityProduit,ProduitResponseDto.class);
    }

    public ProduitResponseDto findByreference(String reference){
        EntityProduit entityProduit = produitDao.findByreference(reference);
        return modelMapper.map(entityProduit,ProduitResponseDto.class);
    }
    public void delete(Integer id){
        produitDao.deleteById(id);
        EntityProduit entityProduit=produitDao.findById(id).get();
        produitDao.delete(entityProduit);
    }
    public ProduitResponseDto update(ProduitRequestDto produitRequestDto, Integer id){
        Optional<EntityProduit> optionalEntityProduit=produitDao.findById(id);
        if(optionalEntityProduit.isPresent()){
            EntityProduit entityProduit=modelMapper.map(produitRequestDto, EntityProduit.class);
            entityProduit.setId(id);
            EntityProduit updated=produitDao.save(entityProduit);
            return modelMapper.map(updated,ProduitResponseDto.class);
        }else{
            throw new EntityNotFoundException("Produit Not Found");
        }
    }
}
