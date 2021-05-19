package com.ml.mutant.domain.adapter.repository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.ml.mutant.domain.model.dto.Dna;
import com.ml.mutant.infraestructure.adapter.repository.entity.EntityDna;
import com.ml.mutant.infraestructure.jpa.RepositoryDnaJPA;

@Repository
public class RepositoryMutantMySql {
	
	private final RepositoryDnaJPA repositoryDnaJPA;
    private ModelMapper modelMapper = new ModelMapper();

	public RepositoryMutantMySql(RepositoryDnaJPA repositoryDnaJPA) {
		this.repositoryDnaJPA = repositoryDnaJPA;
	} 
	
	public void insert(Dna dna) {
		EntityDna entityDna = modelMapper.map(dna, EntityDna.class);
		repositoryDnaJPA.save(entityDna);
	}
	
	public boolean exist(String dna) {
		 EntityDna entityDna = repositoryDnaJPA.getEntityByDna(dna);
		 return entityDna != null;
	}
}
