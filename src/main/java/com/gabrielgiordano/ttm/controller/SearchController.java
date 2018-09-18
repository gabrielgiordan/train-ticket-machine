package com.gabrielgiordano.ttm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gabrielgiordano.ttm.bean.SearchElementBean;
import com.gabrielgiordano.ttm.service.SearchService;

/**
 * The Search Controller for the REST implementation.
 * 
 * @author Gabriel Giordano
 */
@Controller("SearchController")
public class SearchController implements SearchInterface<SearchElementBean> {

  /** The injected search service. */
  @Autowired
  @Qualifier("SearchService")
  private SearchService searchService;

  @RequestMapping("/home")
  public String index() {
    return "index";
  }

  @RequestMapping("/search")
  @ResponseBody
  @Override
  public SearchElementBean searchEmpty() {
    return searchService.search("");
  }

  @RequestMapping("/search/{prefix}")
  @ResponseBody
  @Override
  public SearchElementBean search(@PathVariable String prefix) {
    return searchService.search(prefix);
  }
}
