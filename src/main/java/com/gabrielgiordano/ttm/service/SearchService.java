package com.gabrielgiordano.ttm.service;

import java.util.Collection;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielgiordano.ttm.bean.SearchElementBean;
import com.gabrielgiordano.ttm.bean.StationBean;
import com.gabrielgiordano.ttm.collection.Trie;
import com.gabrielgiordano.ttm.controller.SearchInterface;

/**
 * The Service class for the search functionality.
 * 
 * @author Gabriel Giordano
 */
@Service("SearchService")
public class SearchService implements SearchInterface<SearchElementBean> {

	/** The trie to make the search work. */
	private Trie trie;

	/** The injected station service to get the data. */
	@Autowired
	private StationComponent stationComponent;

	/**
	 * Instantiates a new search service.
	 */
	public SearchService() {}

	/**
	 * Inits after the Spring's station service injection and initializes the cached list and the trie with data.
	 */
	@PostConstruct
	public void init() {

		Collection<StationBean> stations = stationComponent.getStations();
	
		trie = new Trie();

		for (StationBean station : stations) {
			trie.add(station.getName());
		}
	}

	@Override
	public SearchElementBean searchEmpty() {
		return new SearchElementBean();
	}

	@Override
	public SearchElementBean search(String query) {
		return trie.getResult(query);
	}


}
