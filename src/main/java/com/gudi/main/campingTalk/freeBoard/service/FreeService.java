package com.gudi.main.campingTalk.freeBoard.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gudi.main.campingTalk.freeBoard.dao.FreeMapper;
import com.gudi.main.dtoAll.BoardDTO;
import com.gudi.main.dtoAll.PhotoDTO;
import com.gudi.main.util.UploadUtil;

@Service
public class FreeService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired FreeMapper mapper;
	
	// 리스트
	public ArrayList<BoardDTO> freeList() {
		
		return mapper.freeList();
		
	}
	
	// 글쓰기
	public int freeWrite(HashMap<String, String> params) {
		
		logger.info(params.get("title") + "/" + params.get("content") + "/" + params.get("loginId"));
		return mapper.freeWrite(params);
		
	}
	
	// 사진 업로드
	public void freePhoto(MultipartFile[] file, String boardNum) {
		
		HashMap<String, String> map;
		String neww = "";
		String ori = "";
		
		for (int i = 0; i < file.length; i++) {
			map = UploadUtil.fileUpload(file[i]);
			neww = map.get("newFileName");
			ori = map.get("oriFileName");
			
			mapper.freePhoto(neww,ori, boardNum);
			
		}
		
	}
	
	// 사진 불러오기
	public ArrayList<PhotoDTO> callPhoto(int boardNum) {
		
		String divi = "free" + Integer.toString(boardNum);
		return mapper.callPhoto(divi);
		
	}
	
	// 상세보기
	public BoardDTO freeDetail(int boardNum) {
		
		return mapper.freeDetail(boardNum);
		
	}
	
	// 조회수
	public void freeHit(int boardNum) {
		
		mapper.freeHit(boardNum);
		
	}
	
	// 글 삭제
	public int freeDel(int boardNum) {
		
		return mapper.freeDel(boardNum);
		
	}
	
	// 글 수정
	public int freeUpdate(HashMap<String, String> params) {
		
		logger.info(params.get("title" ) + "/" + params.get("content"));
		
		String title = params.get("title");
		String content = params.get("content");
		int boardNum = Integer.parseInt(params.get("boardNum"));
		
		return mapper.freeUpdate(title,content,boardNum);
		
	}
	
	// 사진 수정
	public void freePhotoUpdate(MultipartFile[] file, int boardNum) {
		
		HashMap<String, String> map;
		String neww = "";
		String ori = "";
		
		for (int i = 0; i < file.length; i++) {
			map = UploadUtil.fileUpload(file[i]);
			neww = map.get("newFileName");
			ori = map.get("oriFileName");
			
			mapper.freePhotoUpdate(neww,ori, boardNum);
		}
		
	}
	
	// 사진 삭제
	public void photoDel(HashMap<String, Object> map) {
		
		int boardNum = Integer.parseInt((String)map.get("boardNum"));
		String newFileName = (String) map.get("newFileName");
		
		mapper.photoDel(newFileName, boardNum);
		
	}
	
	// 글 신고
	public void freeReport(HashMap<String, String> map, String loginId) {
		
		map.put("loginId", loginId);
		mapper.freeReport(map);
		
	}
	
	
	
}