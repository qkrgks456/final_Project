package com.gudi.main.campingTalk.reviewBoard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gudi.main.campingTalk.reviewBoard.service.ReviewService;

@Controller
@RequestMapping(value = "/campingTalk")
public class ReviewController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired ReviewService service;

    @RequestMapping(value = "/reviewBoard")
    public String reviewBoard(Model model) {
    	logger.info("리뷰 리스트(리뷰메인) 요청...");
        return "campingTalk/reviewBoard/reviewBoardList";
    }
    
    //리뷰작성 폼 요청
    @RequestMapping(value = "/reviewWriteForm")
    public String reviewWriteForm(Model model) {
    	logger.info("리뷰 작성폼 요청...");
        return "campingTalk/reviewBoard/reviewWriteForm";
    }
    

    
}
