package com.gabrielgiordano.ttm.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gabrielgiordano.ttm.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class StationComponentTests {

	@Autowired
	StationComponent stationService;

	@Test
	public void testStationServiceIsNotNull() {
		assertNotNull(stationService);
	}

	@Test
	public void testHasStations() {
		assertNotNull(stationService.getStations());
		assertTrue(stationService.getStations().size() > 0);
	}

}
