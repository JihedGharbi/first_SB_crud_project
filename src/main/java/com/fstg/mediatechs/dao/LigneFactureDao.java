package com.fstg.mediatechs.dao;

import com.fstg.mediatechs.models.LigneFactureEntity;
import com.fstg.mediatechs.models.LigneFactureKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneFactureDao extends JpaRepository<LigneFactureEntity, LigneFactureKey> {
}
