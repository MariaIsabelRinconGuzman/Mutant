package com.ml.mutant.infraestructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ml.mutant.domain.adapter.dao.DaoDnaMySql;
import com.ml.mutant.domain.adapter.repository.RepositoryMutantMySql;
import com.ml.mutant.domain.service.ServiceMutant;
import com.ml.mutant.domain.service.ServiceStats;

@Configuration
public class BeanService {
	
	@Bean
	public ServiceMutant serviceMutant(RepositoryMutantMySql repositoryMutant) {
		return new ServiceMutant(repositoryMutant);
	}
	
	@Bean
	public ServiceStats serviceStats(DaoDnaMySql daoDna) {
		return new ServiceStats(daoDna);
	}
}
