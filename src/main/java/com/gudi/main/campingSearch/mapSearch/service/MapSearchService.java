package com.gudi.main.campingSearch.mapSearch.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gudi.main.campingSearch.mapSearch.dao.MapSearchMapper;
import com.gudi.main.dtoAll.CampingDTO;

@Service
public class MapSearchService {
	  Logger logger = LoggerFactory.getLogger(this.getClass());
	    
	    @Autowired MapSearchMapper dao;
	

	public HashMap<String, Object> list(int page, int pagePerNum) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int end = page * pagePerNum;
		int start = end - pagePerNum + 1;
		
		//1.list
		ArrayList<CampingDTO> list = dao.list(start,end);
		
		//2.데이터 총 갯수 -> 만들수 있는 페이지
		int totalCnt = dao.allCount();
		logger.info(list.size()+"/"+totalCnt);
		map.put("list", list);
		map.put("cnt", totalCnt);
		
		//총 갯수 21개 pagePerNum 5일 경우 몇 페이지로 만들어야 하나? ->6개
		int pages = (int) (totalCnt%pagePerNum>0 ?  Math.floor(totalCnt/pagePerNum)+1 : Math.floor(totalCnt/pagePerNum));

		page = page>pages ? pages : page; //보여줄 갯수를 바꿧을때 조건문
		
		map.put("currPage", page);
		map.put("pages", pages);
		return map;
	}
}
