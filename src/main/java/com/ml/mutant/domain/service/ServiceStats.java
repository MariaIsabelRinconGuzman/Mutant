package com.ml.mutant.domain.service;

import java.util.List;

import com.ml.mutant.domain.adapter.dao.DaoDnaMySql;
import com.ml.mutant.domain.model.dto.Dna;
import com.ml.mutant.domain.model.dto.Stat;

public class ServiceStats {
	
	private final DaoDnaMySql daoDna;
	
	public ServiceStats(DaoDnaMySql daoDna) {
		this.daoDna = daoDna;
	}
	
	public Stat obtain(){
		Stat stat = new Stat();
		List<Dna> dnas = daoDna.listAllDna();
		for(Dna dna : dnas) {
			if(dna.getType() == 'H') {
				stat.setCount_human_dna(stat.getCount_human_dna()+1);
			}else if(dna.getType() == 'M') {
				stat.setCount_mutant_dna(stat.getCount_mutant_dna()+1);
			}
		}
		if(stat.getCount_human_dna() != 0) {
			stat.setRatio(Double.valueOf(stat.getCount_mutant_dna())/Double.valueOf(stat.getCount_human_dna()));
		}else {
			stat.setRatio(stat.getCount_mutant_dna());
		}
		return stat;
	}
}
