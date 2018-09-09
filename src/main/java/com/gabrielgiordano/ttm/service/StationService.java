package com.gabrielgiordano.ttm.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.gabrielgiordano.ttm.ApplicationProperties;
import com.gabrielgiordano.ttm.bean.StationBean;
import com.gabrielgiordano.ttm.controller.StationInterface;
import com.opencsv.bean.CsvToBeanBuilder;

/**
 * The Station Service class to offer the .csv data.
 * 
 * @author Gabriel Giordano
 */
@Service
public class StationService implements StationInterface<StationBean> {
	
	/** The stations. */
	private Collection<StationBean> stations = new ArrayList<StationBean>();
	
	/**
	 * Instantiates a new station service and get the .csv file using the application.properties to get the path.
	 *
	 * @param properties the Spring's injected properties from application.properties
	 */
	@Autowired
	public StationService(ApplicationProperties properties) {
		
		ClassPathResource csv = new ClassPathResource(properties.getCsv());

		if (csv != null) {
			try {
				
				// Jar files doesn't recognize resources as Files
				InputStreamReader reader = new InputStreamReader(csv.getInputStream());
				stations = new CsvToBeanBuilder<StationBean>(reader).withType(StationBean.class).build().parse();
				
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	@Override
	public Collection<StationBean> getStations() {
		return stations;
	}
}
