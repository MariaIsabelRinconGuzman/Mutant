package com.ml.mutant.domain.model.dto;

public class Dna {
	private int id;
    private String dna;
    private char type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDna() {
		return dna;
	}
	public void setDna(String dna) {
		this.dna = dna;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	public Dna(int id, String dna, char type) {
		this.id = id;
		this.dna = dna;
		this.type = type;
	}
	public Dna() {
	}	
}
