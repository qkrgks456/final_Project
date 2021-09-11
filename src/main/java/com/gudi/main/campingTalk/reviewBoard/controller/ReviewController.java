package com.gudi.main.campingTalk.reviewBoard.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.gudi.main.campingTalk.reviewBoard.service.ReviewService;
import com.gudi.main.dtoAll.BoardDTO;
import com.gudi.main.dtoAll.PhotoDTO;

@Controller
@RequestMapping(value = "/campingTalk")
public class ReviewController {
    
	Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired ReviewService service;

    
    @RequestMapping(value = "/reviewBoard")
    public ModelAndView reviewBoard() {
    	logger.info("리뷰 리스트(리뷰메인) 요청...");
    	
    	ModelAndView mav = new ModelAndView();
    	
    	//글 리스트
    	ArrayList<BoardDTO> dto = service.reviewList();
    	    	
    	mav.addObject("dtoList", dto);
    	mav.setViewName("/campingTalk/reviewBoard/reviewBoardList");
    	
        return mav;
    }
    
    //리뷰작성 폼 요청
    @RequestMapping(value = "/reviewWriteForm")
    public String reviewWriteForm(Model model) {
    	logger.info("리뷰 작성폼 요청...");
        return "campingTalk/reviewBoard/reviewWriteForm";
    }
     
    //새 리뷰등록
    @Transactional(isolation = Isolation.READ_COMMITTED)
    @RequestMapping(value = "/reviewWrite")
    public ModelAndView reviewWrite(@RequestParam HashMap<String, String> params,
    		MultipartFile[] file) {
    	logger.info("리뷰 등록 요청...");
    	
    	ModelAndView mav = new ModelAndView();
    	
    	//리뷰글 등록
    	service.reviewWrite(params);
    	String boardNum = String.valueOf(params.get("boardnum"));
    	System.out.println("suc은 시퀀스 넘버인가?:: "+ boardNum);
    	
    	//파일업로드
    	service.reviewPhoto(file, boardNum);
    	
    	mav.setViewName("redirect:./reviewDetail/"+boardNum);
     	
        return mav;
    }
    
    //리뷰 상세보기
    @RequestMapping(value = "/reviewDetail/{boardNum}")
    public ModelAndView reviewDetail(@PathVariable int boardNum) {
    	logger.info("리뷰 상세보기 요청...");
    	logger.info("상세보기할 글의 넘버:: "+boardNum);
    	
    	ModelAndView mav = new ModelAndView();
    	
    	//사진 불러옴 (여러개임)
    	ArrayList<PhotoDTO> phoDto = service.callPhoto(boardNum);
    	
    	//글 불러옴
    	BoardDTO dto = service.reviewDetail(boardNum);
    	
    	//조회수 올리기
    	service.reviewHit(boardNum);
    	
    	mav.setViewName("campingTalk/reviewBoard/reviewDetail");
    	mav.addObject("dto",dto);
    	mav.addObject("phoDtos",phoDto);

        return mav;
    }
    
    //리뷰 삭제
    @RequestMapping(value = "/reviewDel/{boardNum}")
    public String reviewDel(@PathVariable int boardNum, Model model) {
    	logger.info("리뷰 삭제 요청...");
    	logger.info("삭제한 글의 번호:: "+boardNum);
    	
    	int suc = service.reviewDel(boardNum);
    	if (suc>0) {
    		String delmsg = "리뷰가 삭제되었습니다.";
			model.addAttribute("delmsg",delmsg);
		}
    	
        return "redirect:../reviewBoard";
    }
    
    //리뷰 수정폼요청
    @RequestMapping(value = "/reviewUpdateForm/{boardNum}")
    public ModelAndView reviewUpdateForm(@PathVariable int boardNum) {
    	logger.info("리뷰 수정폼 요청...");
    	logger.info("수정할 글의 글번호:: "+boardNum);
    	
    	//수정폼 요청하면서 기존의 글내용을 전달
    	ModelAndView mav = new ModelAndView();
    	
    	//사진 불러옴
    	ArrayList<PhotoDTO> phoDto = service.callPhoto(boardNum);
    	
    	//글 불러옴
    	BoardDTO dto = service.reviewDetail(boardNum);
    	mav.setViewName("campingTalk/reviewBoard/reviewUpdateForm");
    	mav.addObject("dto",dto);
    	mav.addObject("phoDtos",phoDto);

        return mav;
    }
    
    @Transactional(isolation = Isolation.READ_COMMITTED)
    @RequestMapping(value = "/reviewUpdate")
    public ModelAndView reviewUpdate(@RequestParam HashMap<String, String> params,
    		MultipartFile[] file) {
		logger.info("리뷰 수정 등록 요청...");
    	
		String boardNum = params.get("boardNum");
		
		ModelAndView mav = new ModelAndView();
    	
    	//리뷰글 수정
    	service.reviewUpdate(params);
    	
    	//사진 업뎃
    	service.reviewPhoto(file, boardNum);
    	
    	mav.setViewName("redirect:./reviewDetail/"+boardNum);
     	
        return mav;  	
    }
    
    //newfilename 으로 파일 삭제
    @RequestMapping(value = "/photoDel")
    @ResponseBody
    public void photoDel(@RequestParam HashMap<String, Object> map) {
    	logger.info("리뷰 사진 삭제 요청...");
    	service.photoDel(map);
    }
    
}
