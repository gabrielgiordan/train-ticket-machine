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
public class SearchServiceTests {

	@Autowired
	SearchService searchService;

	@Test
	public void testSearchServiceIsNotNull() {
		assertNotNull(searchService);
	}

	@Test
	public void testSearchResultsNotNull() {
		assertNotNull(searchService.search("a"));
	}
}
