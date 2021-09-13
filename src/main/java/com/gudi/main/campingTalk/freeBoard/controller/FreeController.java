package com.gudi.main.campingTalk.freeBoard.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gudi.main.campingTalk.freeBoard.service.FreeService;
import com.gudi.main.dtoAll.BoardDTO;
import com.gudi.main.dtoAll.PhotoDTO;

@Controller
@RequestMapping(value = "/campingTalk")
public class FreeController {
	
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired FreeService service;
    
    // 글 목록 불러오기
    @RequestMapping(value = "/freeBoard")
    public ModelAndView freeBoard() {
    	
    	logger.info("리스트 요청");
    	
    	ModelAndView mav = new ModelAndView();
    	
    	ArrayList<BoardDTO> dto = service.freeList();
    	    	
    	mav.addObject("dtoList", dto);
    	mav.setViewName("/campingTalk/freeBoard/freeBoardList");
    	
        return mav;
    	
    }
    
    
    // 글 작성 폼
    @RequestMapping(value = "/freeWriteForm")
    public String freeWriteForm(Model model) {
    	logger.info("글쓰기 요청");
        return "campingTalk/freeBoard/freeWriteForm";
    }
    
    // 글쓰기 
    @Transactional(isolation = Isolation.READ_COMMITTED)
    @RequestMapping(value = "/freeWrite")
    public ModelAndView freeWrite(@RequestParam HashMap<String, String> params,
    		MultipartFile[] file) {
    	logger.info("글쓰기 요청2");
    	
    	ModelAndView mav = new ModelAndView();
    	
    	// 글 등록
    	service.freeWrite(params);
    	String boardNum = String.valueOf(params.get("boardnum"));
    	System.out.println("suc은 시퀀스 넘버인가?:: "+ boardNum);
    	
    	// 파일업로드
    	service.freePhoto(file, boardNum);
    	
    	mav.setViewName("redirect:./freeDetail/"+boardNum);
     	
        return mav;
    }
    
    // 상세보기
    @RequestMapping(value = "/freeDetail/{boardNum}")
    public ModelAndView freeDetail(@PathVariable int boardNum) {
    	logger.info("상세보기 요청");
    	
    	ModelAndView mav = new ModelAndView();
    	
    	//사진 불러옴 (여러개임)
    	ArrayList<PhotoDTO> phoDto = service.callPhoto(boardNum);
    	
    	//글 불러옴
    	BoardDTO dto = service.freeDetail(boardNum);
    	
    	//조회수 올리기
    	service.freeHit(boardNum);
    	
    	mav.setViewName("campingTalk/freeBoard/freeDetail");
    	mav.addObject("dto",dto);
    	mav.addObject("phoDtos",phoDto);

        return mav;
    }
    
    // 글 삭제
    @RequestMapping(value = "/freeDel/{boardNum}")
    public String freeDel(@PathVariable int boardNum, Model model) {
    	logger.info("글 삭제");
    	logger.info("삭제한 글 번호 : " + boardNum);
    	
    	int suc = service.freeDel(boardNum);
    	if (suc>0) {
    		String delmsg = "리뷰가 삭제되었습니다.";
			model.addAttribute("delmsg",delmsg);
		}
    	
        return "redirect:../freeBoard";
    }
    
    // 글 수정
    @RequestMapping(value = "/freeUpdateForm/{boardNum}")
    public ModelAndView freeUpdateForm(@PathVariable int boardNum) {
    	logger.info("수정 요청");
    	logger.info("수정할 글의 글번호 : " + boardNum);
    	
    	//수정폼 요청하면서 기존의 글내용을 전달
    	ModelAndView mav = new ModelAndView();
    	
    	//사진 불러옴
    	ArrayList<PhotoDTO> phoDto = service.callPhoto(boardNum);
    	
    	//글 불러옴
    	BoardDTO dto = service.freeDetail(boardNum);
    	mav.setViewName("campingTalk/freeBoard/freeUpdateForm");
    	mav.addObject("dto",dto);
    	mav.addObject("phoDtos",phoDto);

        return mav;
    }
    
    // 글 수정2
    @Transactional(isolation = Isolation.READ_COMMITTED)
    @RequestMapping(value = "/freeUpdate")
    public ModelAndView freeUpdate(@RequestParam HashMap<String, String> params,
    		MultipartFile[] file) {
		logger.info("수정 요청2");
    	
		String boardNum = params.get("boardNum");
		
		ModelAndView mav = new ModelAndView();
    	
    	//리뷰글 수정
    	service.freeUpdate(params);
    	
    	//사진 업뎃
    	service.freePhoto(file, boardNum);
    	
    	mav.setViewName("redirect:./freeDetail/" + boardNum);
     	
        return mav;  	
    }
    
    // newfilename 으로 파일 삭제
    @RequestMapping(value = "/freePhotoDel")
    @ResponseBody
    public void photoDel(@RequestParam HashMap<String, Object> map) {
    	logger.info("리뷰 사진 삭제 요청...");
    	service.photoDel(map);
    }
    
    
    
    
}
