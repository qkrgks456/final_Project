package com.gudi.main.campingSearch.tagSearch.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gudi.main.campingSearch.tagSearch.service.TagSearchService;

@Controller
@RequestMapping(value = "/campingSearch")
public class TagSearchController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired TagSearchService service;
    
    @RequestMapping(value = "/tagSearch/{page}")
    public ModelAndView tagSearch(@PathVariable int page) {
        	return service.lists(page);
    }
    
    
    @RequestMapping(value = "/search/{word}")
    public ModelAndView Search(@PathVariable String word) {
    	logger.info("검색입력"+word);
        	return service.search(word);
    }
}
