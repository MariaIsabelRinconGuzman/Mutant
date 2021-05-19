package com.ml.mutant.domain.adapter.dao;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.ml.mutant.domain.model.dto.Dna;
import com.ml.mutant.infraestructure.adapter.repository.entity.EntityDna;
import com.ml.mutant.infraestructure.jpa.RepositoryDnaJPA;

@Repository
public class DaoDnaMySql {
	
	private final RepositoryDnaJPA repositoryDnaJPA;
    private ModelMapper modelMapper = new ModelMapper();
	
	public DaoDnaMySql(RepositoryDnaJPA repositoryDnaJPA) {
		this.repositoryDnaJPA = repositoryDnaJPA;
	}

	public List<Dna> listAllDna(){
		List<Dna> dnas = new ArrayList<>();
		List<EntityDna> entitys = repositoryDnaJPA.findAll();
		for(EntityDna entity : entitys) {
			Dna dna = modelMapper.map(entity, Dna.class);
			dnas.add(dna);
		}
		return dnas;
	}
}