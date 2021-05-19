package com.ml.mutant.application.comand.handler;

import org.springframework.stereotype.Component;

import com.ml.mutant.domain.service.ServiceMutant;

@Component
public class HandlerMutant {

	private ServiceMutant serviceMutant;	
	
	public HandlerMutant(ServiceMutant serviceMutant) {
		this.serviceMutant = serviceMutant;
	}

	public boolean run(String[] dna){
		return serviceMutant.insertAndValidate(dna);
	}
}
