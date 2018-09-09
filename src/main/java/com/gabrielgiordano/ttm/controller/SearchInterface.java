package com.gabrielgiordano.ttm.controller;

/**
 * The Interface Search related controller and services.
 *
 * @param <E> the search bean element type
 * @author Gabriel Giordano
 */
public interface SearchInterface<E> {
	
	/**
	 * Gets the list of data to be searched.
	 *
	 * @return the string[] containing the data
	 */
	String[] list();

	/**
	 * Performs the search.
	 *
	 * @param query the search query
	 * @return the E with the resulted search bean element
	 */
	E search(String query);
}
