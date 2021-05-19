package com.ml.mutant.infraestructure.jpa;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ml.mutant.infraestructure.adapter.repository.entity.EntityDna;

@Repository
public interface RepositoryDnaJPA extends JpaRepository<EntityDna, Serializable>{
	
	@Query("select e from EntityDna e where e.dna = :dna")
    EntityDna getEntityByDna(@Param("dna") String dna);
}
