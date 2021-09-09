package com.gudi.main.campingServiceCenter.noticeBoard.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gudi.main.campingServiceCenter.noticeBoard.dao.NoticeMapper;
import com.gudi.main.dtoAll.BoardDTO;

@Service
public class NoticeService {
	  Logger logger = LoggerFactory.getLogger(this.getClass());
	  @Autowired NoticeMapper dao;
	
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		ArrayList<BoardDTO> list = dao.list();
	mav.addObject("list", list);
	mav.setViewName("serviceCenter/noticeBoard/noticeBoardList");
	return mav;
		
	}

	public ModelAndView detail(String boardnum) {
		ModelAndView mav = new ModelAndView();
		
		
		return mav;
	}
}
