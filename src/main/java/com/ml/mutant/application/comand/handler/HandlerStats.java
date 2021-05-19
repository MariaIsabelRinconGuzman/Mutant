package com.ml.mutant.application.comand.handler;

import org.springframework.stereotype.Component;

import com.ml.mutant.domain.model.dto.Stat;
import com.ml.mutant.domain.service.ServiceStats;

@Component
public class HandlerStats {

	private ServiceStats serviceStats;	

	public HandlerStats(ServiceStats serviceStats) {
		this.serviceStats = serviceStats;
	}
	

	public Stat run(){
		return serviceStats.obtain();
	}
}
