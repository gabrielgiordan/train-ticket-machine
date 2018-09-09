package com.gabrielgiordano.ttm;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * The configuration class for the "app" prefix in the application.properties file.
 * @author Gabriel Giordano
 */
@Component
@ConfigurationProperties("app")
public class ApplicationProperties {
	
	private String csv;

	/**
	 * Gets the csv into the resources path.
	 *
	 * @return the csv path
	 */
	public String getCsv() {
		return csv;
	}

	/**
	 * Sets the csv resources path.
	 *
	 * @param csv the new csv path
	 */
	public void setCsv(String csv) {
		this.csv = csv;
	}
}
