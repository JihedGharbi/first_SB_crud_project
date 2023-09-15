package com.fstg.mediatechs.dao;

import com.fstg.mediatechs.models.EntityFacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface FactureDao extends JpaRepository<EntityFacture,Integer> {

}
