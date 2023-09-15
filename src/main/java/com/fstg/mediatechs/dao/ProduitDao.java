package com.fstg.mediatechs.dao;

import com.fstg.mediatechs.models.EntityProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitDao extends JpaRepository<EntityProduit,Integer> {
    EntityProduit findByreference(String reference);
}
