package com.ml.mutant.infraestructure.adapter.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "dna")
public class EntityDna {
	@Id
    @GeneratedValue
    private int id;
	@Column
    private String dna;
	@Column
    private char type;   
    
	public EntityDna() {
	}
	
	public EntityDna(int id, String dna, char type) {
		this.dna = dna;
		this.type = type;
	}

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
}
