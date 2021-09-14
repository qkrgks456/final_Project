package com.gudi.main.campingSearch.tagSearch.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gudi.main.campingSearch.tagSearch.dao.TagSearchMapper;
import com.gudi.main.dtoAll.CampingDTO;
import com.gudi.main.util.HansolUtil;

@Service
public class TagSearchService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	  @Autowired TagSearchMapper dao;


	public ModelAndView lists(int page) {
		ModelAndView mav = new ModelAndView();
		int total = dao.total();
		HashMap<String,Object> map = HansolUtil.pagination(page, 10, total);
		if(page == 1) {
			page = 0;
		}else {
			page = (page-1)*10;
		}
		ArrayList<CampingDTO> list = dao.lists(page);
		map.put("list", list);
		map.put("url","tagSearch");
		mav.addObject("map", map);
		mav.setViewName("campingSearch/tagSearch/tagSearchMain");
		return mav;
	}


	public ModelAndView search(int page,String word) {
		ModelAndView mav = new ModelAndView();
		int total = dao.total();
		HashMap<String,Object> map = HansolUtil.pagination(page, 10, total);
		if(page == 1) {
			page = 0;
		}else {
			page = (page-1)*10;
		}
		ArrayList<CampingDTO> list = dao.search(page,word);
		map.put("list", list);
		map.put("url", "search");
		map.put("word", word);
		mav.addObject("map", map);
		mav.setViewName("campingSearch/tagSearch/tagSearch");
		return mav;
	}
}
