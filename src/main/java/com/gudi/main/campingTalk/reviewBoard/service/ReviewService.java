package com.gudi.main.campingTalk.reviewBoard.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gudi.main.campingTalk.reviewBoard.dao.ReviewMapper;
import com.gudi.main.dtoAll.BoardDTO;
import com.gudi.main.dtoAll.PhotoDTO;
import com.gudi.main.util.UploadUtil;

@Service
public class ReviewService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired ReviewMapper dao;

	
	public void reviewPhoto(MultipartFile[] file, String boardNum) {
		
		HashMap<String, String> map;
		String neww = "";
		String ori = "";
		
		for (int i = 0; i < file.length; i++) {
			map = UploadUtil.fileUpload(file[i]);
			neww = map.get("newFileName");
			ori = map.get("oriFileName");
			
			dao.reviewPhoto(neww,ori, boardNum);
		};
		
		/*
		HashMap<String, String> map = UploadUtil.fileUpload(file);
		
		String neww = map.get("newFileName");
		String ori = map.get("oriFileName");
		logger.info(neww + " / " + ori);
		
		
		dao.reviewPhoto(neww,ori, boardNum);
		*/
	}

	public int reviewWrite(HashMap<String, String> params) {
		logger.info(params.get("title")+" / "+params.get("content"));
		return dao.reviewWrite(params);
	}

	public BoardDTO reviewDetail(int boardNum) {
		return dao.reviewDetail(boardNum);	
	}
	
	public ArrayList<PhotoDTO> callPhoto(int boardNum) {
		
		String divi = "review_"+Integer.toString(boardNum);
		return dao.callPhoto(divi);
	}

	public int reviewDel(int boardNum) {
		return dao.reviewDel(boardNum);
	}

	public ArrayList<BoardDTO> reviewList() {
		return dao.reviewList();
	}

	public int reviewUpdate(HashMap<String, String> params) {
		logger.info(params.get("title")+" / "+params.get("content"));
		
		String title = params.get("title");
		String content = params.get("content");
		int boardNum = Integer.parseInt(params.get("boardNum"));
		
		return dao.reviewUpdate(title,content,boardNum);
	}

	public void reviewPhotoUpdate(MultipartFile[] file, int boardNum) {
		
		HashMap<String, String> map;
		String neww = "";
		String ori = "";
		
		for (int i = 0; i < file.length; i++) {
			map = UploadUtil.fileUpload(file[i]);
			neww = map.get("newFileName");
			ori = map.get("oriFileName");
			
			dao.reviewPhotoUpdate(neww,ori, boardNum);
		};
		
		/*
		HashMap<String, String> map = UploadUtil.fileUpload(file);
		
		String neww = map.get("newFileName");
		String ori = map.get("oriFileName");
		logger.info(neww + " / " + ori);
		
		dao.reviewPhotoUpdate(neww, ori, boardNum);
		*/
	}

	public void photoDel(HashMap<String, Object> map) {
		int boardNum = Integer.parseInt((String)map.get("boardNum"));
		String newFileName = (String) map.get("newFileName");
		
		dao.photoDel(newFileName, boardNum);
	}

	public void reviewHit(int boardNum) {
		logger.info("조회수 올리셈::");
		dao.reviewHit(boardNum);
	}
	

}
