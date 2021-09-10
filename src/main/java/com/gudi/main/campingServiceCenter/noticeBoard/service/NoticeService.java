package com.gudi.main.campingServiceCenter.noticeBoard.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.gudi.main.campingServiceCenter.noticeBoard.dao.NoticeMapper;
import com.gudi.main.dtoAll.BoardDTO;

@Service
public class NoticeService {
	  Logger logger = LoggerFactory.getLogger(this.getClass());
	  @Autowired NoticeMapper dao;
	
	  public HashMap<String, Object> list(int page, int pagePerNum) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			int end = page * pagePerNum;
			int start = end - pagePerNum + 1;
			//1.list
			ArrayList<BoardDTO> list = dao.list(start,end);
			
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

	  @Transactional
	public ModelAndView detail(String boardnum) {
		ModelAndView mav = new ModelAndView();
		dao.up(boardnum);
		BoardDTO dto = dao.detail(boardnum);
		
		
		return mav;
	}
}
