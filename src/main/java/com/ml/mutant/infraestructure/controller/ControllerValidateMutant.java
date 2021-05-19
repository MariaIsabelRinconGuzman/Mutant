package com.ml.mutant.infraestructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.ml.mutant.application.comand.ComandDna;
import com.ml.mutant.application.comand.handler.HandlerMutant;

@RestController
@RequestMapping(value = "/mutant/")
public class ControllerValidateMutant {
	private final HandlerMutant handlerMutant;

    public ControllerValidateMutant(HandlerMutant handlerMutant) {
    	this.handlerMutant = handlerMutant;
	}

	@PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void validateMutant(@RequestBody ComandDna comandDna){
		if(null == comandDna.getDna()) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Dna is null");
		}
        this.handlerMutant.run(comandDna.getDna());
    }
}
