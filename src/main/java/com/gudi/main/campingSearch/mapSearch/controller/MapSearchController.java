package com.gudi.main.campingSearch.mapSearch.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gudi.main.campingSearch.mapSearch.service.MapSearchService;

@Controller
@RequestMapping(value = "/campingSearch")
public class MapSearchController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired MapSearchService service;

    @RequestMapping(value = "/mapSearch")
    public String mapSearch(Model model) {
        return "campingSearch/mapSearch/mapSearchMain";
    }
    
    @ResponseBody
    @RequestMapping(value="/mapSearchList/{pagePerNum}/{page}")
	public HashMap<String, Object> mapSearchList(@PathVariable int pagePerNum, @PathVariable int page){
		logger.info("pagePerNum : {} / page : {}",pagePerNum,page);
		HashMap<String, Object> map =  service.list(page, pagePerNum);
		return map;
	}
}
