package com.ml.mutant.domain.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.ml.mutant.domain.adapter.repository.RepositoryMutantMySql;
import com.ml.mutant.domain.model.dto.Dna;

public class ServiceMutant {
	
	private final RepositoryMutantMySql repositoryMutant;
	
	public ServiceMutant(RepositoryMutantMySql repositoryMutant) {
		this.repositoryMutant = repositoryMutant;
	}

	public boolean insertAndValidate(String[] stringDna) {
		boolean isMutant = isMutant(stringDna);
		insertInBd(isMutant, textConvert(stringDna));
		if(!isMutant){
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This DNA is for human");
		}
		return isMutant;
	}
	
	private String textConvert(String[] arraystring) {
		StringBuilder stringBuilder = new StringBuilder();
		for(String stringForArray : arraystring) {
			stringBuilder.append(stringForArray);
			stringBuilder.append(",");
		}
		return stringBuilder.toString();
	}
	
	
	private void insertInBd(boolean isMutant, String stringDna){
		if(!repositoryMutant.exist(stringDna)) {
			System.out.println("No esta en bd");
			char type = isMutant ? 'M' : 'H';
			Dna dna = new Dna(0, stringDna, type);
			repositoryMutant.insert(dna);
		}
	}
	
	private boolean isMutant(String[] dna) {
		boolean foundRight = false, foundLeft = false, foundUp = false, foundDown = false, foundUpRight = false,
				foundDownRight = false, foundUpLeft = false, foundDownLeft = false;
		int sequencesFound = 0;
		int rows = dna.length;		
		int columns = dna.length;
		char[][] dnaMatrix = new char[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if(dna[i].charAt(j) != '"' && dna[i].charAt(j) != '{') {
					dnaMatrix[i][j] = dna[i].charAt(j);
				}		
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				char letterToSearch = dnaMatrix[i][j];
				String letterDna = "ATCG";
				if (letterDna.indexOf(letterToSearch) >= 0) {
					if (columns - j >= 3) {
						foundRight = letterToSearch == dnaMatrix[i][j + 1] && letterToSearch == dnaMatrix[i][j + 2]
								&& letterToSearch == dnaMatrix[i][j + 3];
					}
					if (j >= 3) {
						foundLeft = letterToSearch == dnaMatrix[i][j - 1] && letterToSearch == dnaMatrix[i][j - 2]
								&& letterToSearch == dnaMatrix[i][j - 3];
					}
					if (i >= 3) {
						foundUp = letterToSearch == dnaMatrix[i - 1][j] && letterToSearch == dnaMatrix[i - 2][j]
								&& letterToSearch == dnaMatrix[i - 3][j];
					}
					if (rows - i >= 3) {
						foundDown = letterToSearch == dnaMatrix[i + 1][j] && letterToSearch == dnaMatrix[i + 2][j]
								&& letterToSearch == dnaMatrix[i + 3][j];
					}
					if (i >= 3 && columns - j >= 3) {
						foundUpRight = letterToSearch == dnaMatrix[i - 1][j + 1]
								&& letterToSearch == dnaMatrix[i - 2][j + 2]
								&& letterToSearch == dnaMatrix[i - 3][j + 3];
					}
					if (rows - i >= 3 && columns - j >= 3) {
						foundDownRight = letterToSearch == dnaMatrix[i + 1][j + 1]
								&& letterToSearch == dnaMatrix[i + 2][j + 2]
								&& letterToSearch == dnaMatrix[i + 3][j + 3];
					}
					if (i >= 3 && j >= 3) {
						foundUpLeft = letterToSearch == dnaMatrix[i - 1][j - 1]
								&& letterToSearch == dnaMatrix[i - 2][j - 2]
								&& letterToSearch == dnaMatrix[i - 3][j - 3];
					}
					if (j >= 3 && rows - i >= 3) {
						foundDownLeft = letterToSearch == dnaMatrix[i + 1][j - 1]
								&& letterToSearch == dnaMatrix[i + 1][j - 2]
								&& letterToSearch == dnaMatrix[i + 3][j - 3];
					}
					if (foundRight || foundLeft || foundUp || foundDown || foundUpRight || foundDownRight || foundUpLeft
							|| foundDownLeft) {
						sequencesFound++;
					}
				}
			}
		}
		System.out.println("secuencia "+ sequencesFound);
		if (sequencesFound > 1) {
			return true;
		}
		return false;
	}
}
