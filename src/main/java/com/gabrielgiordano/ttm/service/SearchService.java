package com.gabrielgiordano.ttm.service;

import java.util.ArrayList;
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
	
	/** A cached list only for runtime speed purposes. */
	private Collection<String> cachedList;

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
		
		cachedList = new ArrayList<>();
		trie = new Trie();

		for (StationBean station : stations) {
			
			System.out.println(station.getName());
			trie.add(station.getName());
			cachedList.add(station.getName());
		}
	}

	@Override
	public Collection<String> list() {
		return cachedList;
	}

	@Override
	public SearchElementBean search(String query) {
		return trie.getResult(query);
	}


}
