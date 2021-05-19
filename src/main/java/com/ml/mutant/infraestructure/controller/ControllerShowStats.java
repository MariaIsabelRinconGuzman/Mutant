package com.ml.mutant.infraestructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ml.mutant.application.comand.handler.*;
import com.ml.mutant.domain.model.dto.Stat;

@RestController
@RequestMapping(value = "/stats")
public class ControllerShowStats {
	private final HandlerStats handlerStats;

	public ControllerShowStats(HandlerStats handlerStats) {
		this.handlerStats = handlerStats;
	}
	
	@GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Stat showStats(){
        return handlerStats.run();
    }
}
