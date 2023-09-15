package com.fstg.mediatechs.dao;

import com.fstg.mediatechs.models.EntityClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<EntityClient,Integer> {
    EntityClient findByNom (String nom);
}
