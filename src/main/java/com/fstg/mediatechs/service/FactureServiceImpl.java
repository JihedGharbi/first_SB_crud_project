package com.fstg.mediatechs.service;

import com.fstg.mediatechs.dao.FactureDao;
import com.fstg.mediatechs.dto.FactureDto;
import com.fstg.mediatechs.models.EntityFacture;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("Fimpl")
public class FactureServiceImpl {
    private FactureDao factureDao;


    public FactureServiceImpl(FactureDao factureDao) {
        this.factureDao = factureDao;

    }
  /*  public Optional<FactureDto> save(EntityFacture entityFacture){
        return factureDao.save(entityFacture);
    }*/
    public List<EntityFacture> findAll(){
        return factureDao.findAll();
    }
}
