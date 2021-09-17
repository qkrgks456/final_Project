package com.gudi.main.campingServiceCenter.questionBoard.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.gudi.main.campingServiceCenter.questionBoard.dao.QuestionMapper;
import com.gudi.main.dtoAll.BoardDTO;
import com.gudi.main.dtoAll.PhotoDTO;
import com.gudi.main.util.HansolUtil;
import com.gudi.main.util.UploadUtil;

@Service
public class QuestionService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	QuestionMapper dao;

	public HashMap<String, Object> list(int page, int pagePerNum) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int end = page * pagePerNum;
		int start = end - pagePerNum + 1;
		// 1.list
		ArrayList<BoardDTO> list = dao.list(start, end);

		// 2.데이터 총 갯수 -> 만들수 있는 페이지
		int totalCnt = dao.allCount();
		logger.info(list.size() + "/" + totalCnt);
		map.put("list", list);
		map.put("cnt", totalCnt);
		// 총 갯수 21개 pagePerNum 5일 경우 몇 페이지로 만들어야 하나? ->6개
		int pages = (int) (totalCnt % pagePerNum > 0 ? Math.floor(totalCnt / pagePerNum) + 1
				: Math.floor(totalCnt / pagePerNum));
		page = page > pages ? pages : page; // 보여줄 갯수를 바꿧을때 조건문
		map.put("currPage", page);
		map.put("pages", pages);
		return map;
	}

	

	@Transactional
	public ModelAndView detail(int boardNum) {
		ModelAndView mav = new ModelAndView();
		dao.up(boardNum);
		
		/*
		ArrayList<PhotoDTO> phoDto = dao.callPhoto(boardNum);
		*/
		BoardDTO dto = dao.detail(boardNum);
		mav.addObject("dto", dto);
		
		/*
		ArrayList<PhotoDTO> file = dao.file(boardNum);
		mav.addObject("phoDtos", phoDto);
		*/
		mav.addObject("file" /*, file*/);
		mav.setViewName("/serviceCenter/questionBoard/questionDetail");
		return mav;
	}
	

	public int questionWrite(HashMap<String, String> params) {
		logger.info(params.get("title") + " / " + params.get("content"));
		return dao.questionWrite(params);

	}

 /*
	public void questionPhoto(MultipartFile[] file, String boardNum) {
		HashMap<String, String> map;
		String neww = "";
		String ori = "";

		for (int i = 0; i < file.length; i++) {
			map = UploadUtil.fileUpload(file[i]);
			neww = map.get("newFileName");
			ori = map.get("oriFileName");

			dao.questionPhoto(neww, ori, boardNum);

		}

	}
	*/

	public int questionDel(int boardNum) {
		return dao.questionDel(boardNum);
	}

	
	public ModelAndView update(int boardNum) {
		//수정폼 요청하면서 기존의 글내용을 전달
    	ModelAndView mav = new ModelAndView();
    	
    	/*
    	//사진 불러옴
    	ArrayList<PhotoDTO> phoDto = dao.callPhoto(boardNum);
    	*/ 
    	
    	//글 불러옴
    	BoardDTO dto = dao.detail(boardNum);
    	mav.setViewName("/serviceCenter/questionBoard/questionUpdateForm");
    	mav.addObject("dto",dto);
    	/*
    	mav.addObject("phoDtos",phoDto);
    	*/
		return mav;
	}

	public int questionUpdate(HashMap<String, String> params) {
logger.info(params.get("title")+" / "+params.get("content"));
		
		String title = params.get("title");
		String content = params.get("content");
		int boardNum = Integer.parseInt(params.get("boardNum"));
		return dao.questionUpdate(title,content,boardNum);
		
	}



	public ModelAndView list(int page) {
		ModelAndView mav = new ModelAndView();
		int total = dao.allCount();
		HashMap<String, Object> map = HansolUtil.pagination(page, 10, total);
		if (page == 1) {
			page = 0;
		} else {
			page = (page - 1) * 10;
		}
		ArrayList<BoardDTO> list = dao.lists(page);
		map.put("list", list);
		mav.addObject("map", map);
		mav.setViewName("/serviceCenter/questionBoard/questionBoardList");
		return mav;
	}
	

	/*
	public void photoDel(HashMap<String, Object> map) {
		int boardNum = Integer.parseInt((String)map.get("boardNum"));
		String newFileName = (String) map.get("newFileName");
		
		dao.photoDel(newFileName, boardNum);		
	}
	*/
}
