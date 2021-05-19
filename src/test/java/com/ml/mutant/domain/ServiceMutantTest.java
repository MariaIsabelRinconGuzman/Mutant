package com.ml.mutant.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;

import com.ml.mutant.domain.adapter.repository.RepositoryMutantMySql;
import com.ml.mutant.domain.service.ServiceMutant;

public class ServiceMutantTest {
	
	private RepositoryMutantMySql repositoryMutant;
	private ServiceMutant serviceMutant;
	
	@BeforeEach
    public void init() {
        repositoryMutant = Mockito.mock(RepositoryMutantMySql.class);
        serviceMutant = new ServiceMutant(repositoryMutant);
    }
	
	@Test
	public void insertAndValidateMutant() {
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		Mockito.when(repositoryMutant.exist(Mockito.anyString())).thenReturn(true);
		boolean isMutant = serviceMutant.insertAndValidate(dna);
		Assertions.assertTrue(isMutant);
	}
	
	@Test
	public void insertAndValidateHuman() {
		String[] dna = {"ATGCGA",
						"CAGTGC",
						"TTBTGT",
						"AGAANG",
						"CNCCTA",
						"TCACTG"};
		Mockito.when(repositoryMutant.exist(Mockito.anyString())).thenReturn(false);
		ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
			serviceMutant.insertAndValidate(dna);
        });
		Assertions.assertEquals("403 FORBIDDEN \"This DNA is for human\"", exception.getMessage());
	}

}
