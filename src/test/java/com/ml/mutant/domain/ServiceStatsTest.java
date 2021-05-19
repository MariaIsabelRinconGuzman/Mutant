package com.ml.mutant.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ml.mutant.domain.adapter.dao.DaoDnaMySql;
import com.ml.mutant.domain.model.dto.Dna;
import com.ml.mutant.domain.model.dto.Stat;
import com.ml.mutant.domain.service.ServiceStats;

public class ServiceStatsTest {
	
	private DaoDnaMySql daoDna;
	private ServiceStats serviceStats;
	
	@BeforeEach
    public void init() {
		daoDna =  Mockito.mock(DaoDnaMySql.class);
		serviceStats = new ServiceStats(daoDna);
	}
	
	@Test
	public void obtainStats() {
		List<Dna> dnas = new ArrayList<>();
		dnas.add(new Dna(0, "SDGDGD", 'H'));
		dnas.add(new Dna(0, "DGDHGDF", 'M'));
		dnas.add(new Dna(0, "FDSFGDG", 'M'));
		Mockito.when(daoDna.listAllDna()).thenReturn(dnas);
		Stat stat = serviceStats.obtain();
		Assertions.assertEquals(stat.getRatio(), 2.0);
	}

}
