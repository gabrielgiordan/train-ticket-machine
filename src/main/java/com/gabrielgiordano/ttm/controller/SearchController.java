package com.gabrielgiordano.ttm.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielgiordano.ttm.bean.SearchElementBean;
import com.gabrielgiordano.ttm.service.SearchService;

/**
 * The Search Controller for the REST implementation.
 * 
 * @author Gabriel Giordano
 */
@RestController("SearchController")
public class SearchController implements SearchInterface<SearchElementBean> {

	/** The injected search service. */
	@Autowired
	@Qualifier("SearchService")
	private SearchService searchService;
	
	@RequestMapping("/search")
	@Override
	public Collection<String> list() {
		return searchService.list();
	}
	
	@RequestMapping("/search/{prefix}")
	@Override
	public SearchElementBean search(@PathVariable String prefix) {
		return searchService.search(prefix);
	}
}
