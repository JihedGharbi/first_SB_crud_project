package com.fstg.mediatechs.service;

import com.fstg.mediatechs.dao.LigneFactureDao;
import com.fstg.mediatechs.models.LigneFactureEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LFimpl")
public class LigneFactureServiceImpl {
    private LigneFactureDao ligneFactureDao;

    public LigneFactureServiceImpl(LigneFactureDao ligneFactureDao) {
        this.ligneFactureDao = ligneFactureDao;
    }
    public LigneFactureEntity save(LigneFactureEntity ligneFactureEntity){
        return ligneFactureDao.save(ligneFactureEntity);
    }
    public List<LigneFactureEntity>findAll(){
        return ligneFactureDao.findAll();
    }
}
